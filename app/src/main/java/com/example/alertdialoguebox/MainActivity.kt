package com.example.alertdialoguebox

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Confirm Exit !")
            builder1.setMessage("Are you sure you want to exit the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                // Action to be performed when "Exit" is clicked
                finish()
            })
            builder1.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                // Action to be performed when "Cancel" is clicked
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener{
            val ageGrps = arrayOf("0-12", "12-20", "20-30")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which age group do you belong to?")
            builder2.setSingleChoiceItems(ageGrps, 0, DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when user clicks on any option
                Toast.makeText(this, "You belong to age group ${ageGrps[i]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder2.show()
        }


        binding.btn3.setOnClickListener {
            val webSeries = arrayOf("GOT", "Breaking Bad", "Prison Break")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which of the following Web Series have you watched?")
            builder3.setMultiChoiceItems(webSeries, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You have watched ${webSeries[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder3.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->  })
            builder3.show()
        }

    }
}