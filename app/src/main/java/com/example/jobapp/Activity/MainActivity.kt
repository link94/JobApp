package com.example.jobapp.Activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.manager.Lifecycle
import com.example.jobapp.Adapter.CategoryAdapter
import com.example.jobapp.Adapter.JobAdapter
import com.example.jobapp.Adapter.PhotoJobAdapter
import com.example.jobapp.Adapter.PhotoJob
import com.example.jobapp.Model.JobModel
import com.example.jobapp.R
import com.example.jobapp.ViewModel.MainViewModel
import com.example.jobapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewPager: ViewPager2
    lateinit var indicator: CircleIndicator3
    lateinit var adapter: PhotoJobAdapter

//    private lateinit var adapter: PhotoJobAdapter
//    private val handler = Handler(Looper.getMainLooper())
//    private val runnable = object : Runnable {
//        override fun run() {
//            val currentItem = viewPager.currentItem
//            val nextItem = if (currentItem == adapter.itemCount - 1) 0 else currentItem + 1
//            viewPager.setCurrentItem(nextItem, true)
//            handler.postDelayed(this, 3000)
//        }
//    }

    private val mainViewModel:MainViewModel by viewModels()

    private var imageList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initLocation()
        initRecyclerViewCat()
        initRecyclerViewSuggest()
        initRecyclerViewRecent("0")


        viewPager = binding.viewPager2
        indicator = binding.indicator

        val images = listOf(
            PhotoJob(R.drawable.logo1),
            PhotoJob(R.drawable.logo2),
            PhotoJob(R.drawable.logo3),
            PhotoJob(R.drawable.logo4),
            PhotoJob(R.drawable.logo5),
            PhotoJob(R.drawable.logo6),
        )

        val adapter = PhotoJobAdapter(images)
        viewPager.adapter = adapter
        indicator.setViewPager(viewPager)
        lifecycleScope.launch {
            while (true) {
                delay(1500)
                val nextItem = (viewPager.currentItem + 1) % adapter.itemCount
                viewPager.setCurrentItem(nextItem, true)
            }
        }
    }

    private fun initRecyclerViewRecent(cat: String) {
        var data: List<JobModel>
        if(cat =="0"){
            data = mainViewModel.loadData().sortedBy { it.category }
        }else{
            data = mainViewModel.loadData().filter { it.category == cat }

        }

        binding.viewRecent.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.viewRecent.adapter = JobAdapter(data)
    }

    private fun initRecyclerViewSuggest() {
        binding.progressBarSuggest.visibility = View.VISIBLE
        binding.viewSuggested.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.viewSuggested.adapter = JobAdapter(mainViewModel.loadData())
        binding.progressBarSuggest.visibility = View.GONE
    }

    private fun initRecyclerViewCat() {
        binding.progressBarCategory.visibility = View.VISIBLE
        binding.viewCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewCategory.adapter = CategoryAdapter(mainViewModel.loadCategory(), object :CategoryAdapter.ClickListener{
            override fun onClick(category: String) {
                initRecyclerViewRecent(category)
            }

        })
        binding.progressBarCategory.visibility = View.GONE
    }

    private fun initLocation() {
        val adpter = ArrayAdapter(this,R.layout.spinner_item,mainViewModel.loadLocation())
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.locationSpin.adapter = adpter
    }
}