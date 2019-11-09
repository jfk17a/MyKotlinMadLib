package com.example.mykotlinmadlib

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.myfirstkotlinapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Function gets the name, stores it, then hands it to the DisplayMessageActivity to start that activity
    fun sendMessage (view: View){

        //Get view implemented and start a shavedPref to save words
        val nameView = findViewById<EditText>(R.id.nameView)
        val wordEndingInIngView = findViewById<EditText>(R.id.wordEndingInIngView)
        val bodyPartView = findViewById<EditText>(R.id.bodyPartView)
        val somethingBigView = findViewById<EditText>(R.id.somethingBigView)
        val noun1View = findViewById<EditText>(R.id.noun1View)
        val itemView = findViewById<EditText>(R.id.itemView)
        val emotionView = findViewById<EditText>(R.id.emotionView)
        val rankingView = findViewById<EditText>(R.id.rankingView)
        val noun2View = findViewById<EditText>(R.id.noun2View)
        val sharedPref = getSharedPreferences(getString(R.string.preference),Context.MODE_PRIVATE)

        //Get the words to pass into the saved values
        val name = nameView.text.toString()
        val wordEndingInIng = wordEndingInIngView.text.toString()
        val bodyPart = bodyPartView.text.toString()
        val somethingBig = somethingBigView.text.toString()
        val noun1 = noun1View.text.toString()
        val item = itemView.text.toString()
        val emotion = emotionView.text.toString()
        val ranking = rankingView.text.toString()
        val noun2 = noun2View.text.toString()

        //Make sure they actually changed all the words
        if ((name != "Name")&&(wordEndingInIng != "Word Ending In -ing")&&(bodyPart != "Body Part")&&(somethingBig != "Something Big")&&(noun1 != "Noun")&&(item != "Item")&&(emotion != "Emotion")&&(ranking != "Ranking")&&(noun2 != "Noun")) {

            //pass in the messages into the saved content
            with(sharedPref.edit()) {
                putString(getString(R.string.name_string), name)
                putString(getString(R.string.ing_string), wordEndingInIng)
                putString(getString(R.string.body_string), bodyPart)
                putString(getString(R.string.big_string), somethingBig)
                putString(getString(R.string.noun1_string), noun1)
                putString(getString(R.string.item_string), item)
                putString(getString(R.string.emotion_string), emotion)
                putString(getString(R.string.ranking_string), ranking)
                putString(getString(R.string.noun2_string), noun2)
                commit()
            }

            //Off to the next activity
            val intent = Intent(this, MadLibActivity::class.java).apply {}
            startActivity(intent)

        } else {
            //No no no, give use content to use
            Toast.makeText(this, "Fill out all fields to enjoy your Mad Lib.", Toast.LENGTH_LONG).show()
        }
    }
}
