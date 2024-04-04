package com.example.pictoria

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    var names = arrayOf("You got this","Remember why you started","Difficult roads lead to beautiful destinations","You can do it","You can win if you want")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val next = findViewById<ImageButton>(R.id.btnNext)
        val quote = findViewById<TextView>(R.id.tvQuote)

        prev.setOnClickListener {
            //current Image Id in string
            val idCurrentImage = "ivMotivation$currentImage"
            //converting the String to int address associated with it
            //idCurrentImage is the string type, id is the thing which we are trying to convert (or with we are currently working)
            val idCurrentImageIntFormat =
                this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image = findViewById(idCurrentImageIntFormat)
            image.alpha = 0f

            //handling the corner case from 0-> to 4th image
            currentImage = (5 + currentImage - 1) % 5
            val idImageToShowString = "ivMotivation$currentImage"
            val idImagetoShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImagetoShowInt)
            image.alpha = 1f
            quote.text = names[currentImage]
        }

        next.setOnClickListener {
            //current Image Id in string
            val idCurrentImage = "ivMotivation$currentImage"
            //converting the String to int address associated with it
            //idCurrentImage is the string type, id is the thing which we are trying to convert (or with we are currently working)
            val idCurrentImageIntFormat =
                this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image = findViewById(idCurrentImageIntFormat)
            image.alpha = 0f

            //handling the corner case from 0-> to 4th image
            currentImage = (5 + currentImage + 1) % 5
            val idImageToShowString = "ivMotivation$currentImage"
            val idImagetoShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImagetoShowInt)
            image.alpha = 1f
            quote.text = names[currentImage]
        }
    }


}
