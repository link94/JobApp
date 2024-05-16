package com.example.jobapp.Repository

import com.example.jobapp.Model.JobModel

class MainRepository {
    val location = listOf("LosAngles, USA", "London, UK","HaNoi, VietNam","Pari, France")
    val category = listOf("all", "Accountant", "Programmer", "Write")

    val exampleText: String =
        "We are searching for a talented and motivated this job to join our growing team. In the role, you will be responsible for this job and will be responsible for this job."
    val items = listOf(
        JobModel(
            "UI Designer",
            "ChabokSoft",
            "logo1",
            "Full-Time",
            "Remote",
            "Internship",
            "NewYork, USA",
            "\$38k - \$46k",
            "2",
            exampleText,
            exampleText
        ),
        JobModel(
            "Accountants",
            "KianSoft",
            "logo2",
            "Part-Time",
            "Remote",
            "in person",
            "LosAngles, USA",
            "\$26k - \$36k",
            "1",
            exampleText,
            exampleText
        ),
        JobModel(
            "The author of the news",
            "MakanSoft",
            "logo3",
            "Part-Time",
            "Remote",
            "Seniur level",
            "NewYork, USA",
            "\$20k - \$23k",
            "3",
            exampleText,
            exampleText
        ),
        JobModel(
            "Kotlin Progammer",
            "TestSoft",
            "logo4",
            "Full-Time",
            "Remote",
            "Internship",
            "LosAngles, USA",
            "\$38k - \$40k",
            "2",
            exampleText,
            exampleText
        ),
        JobModel(
            "Java Progammer",
            "Fsoft",
            "logo5",
            "Part-Time",
            "Remote",
            "Internship",
            "Hanoi, VietNam",
            "\$2k - \$3k",
            "2",
            exampleText,
            exampleText
        ),
        JobModel(
            "Nhung Progammer",
            "VNPT",
            "logo6",
            "Full-Time",
            "Remote",
            "Internship",
            "HaNoi, VietNam",
            "\$3k - \$4k",
            "2",
            exampleText,
            exampleText
        )
    )

}