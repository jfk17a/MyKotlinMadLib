package com.example.mykotlinmadlib

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_mad_lib.*
import kotlin.random.Random

class MadLibActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mad_lib)

        //Get words from the sharedPref
        val sharedPref = getSharedPreferences(getString(R.string.preference), Context.MODE_PRIVATE)
        val defaultValue = resources.getString(R.string.app_name)
        val name = sharedPref.getString(getString(R.string.name_string), defaultValue)
        val ingString = sharedPref.getString(getString(R.string.ing_string), defaultValue)
        val bodyPart = sharedPref.getString(getString(R.string.body_string), defaultValue)
        val somethingBig = sharedPref.getString(getString(R.string.big_string), defaultValue)
        val noun1 = sharedPref.getString(getString(R.string.noun1_string), defaultValue)
        val item = sharedPref.getString(getString(R.string.item_string), defaultValue)
        val emotion = sharedPref.getString(getString(R.string.emotion_string), defaultValue)
        val ranking = sharedPref.getString(getString(R.string.ranking_string), defaultValue)
        val noun2 = sharedPref.getString(getString(R.string.noun2_string), defaultValue)

        //Find the end points of each value in the word in the overall message
        val nameLength = name!!.count() + 5
        val ingLength = nameLength + 17 + ingString!!.count()
        val bodyLength = ingLength + 40 + bodyPart!!.count()
        val bigLength = bodyLength + 15 + somethingBig!!.count()
        val noun1Length = bigLength + 7 + noun1!!.count()
        val itemLength = noun1Length + 22 + item!!.count()
        val emotionLength = itemLength + 25 + emotion!!.count()
        val rankingLength = emotionLength + 38 + ranking!!.count()
        val noun2Length = rankingLength + 1 + noun2!!.count()

        //Build the message
        val messageView = "Dear " + name + ", you are a very " + ingString + " person. Some could say that you have a " + bodyPart + " the size of a " + somethingBig + ". Even " + noun1 + " have nothing on your " + item + " collection, so don't be " + emotion + " because we all know that you are the " + ranking + " " + noun2 + "."

        //Make it an editable message
        val spannableMessage = SpannableString(messageView)

        //Color the words in the message
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),5,nameLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),nameLength + 17,ingLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),ingLength + 40,bodyLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),bodyLength + 15,bigLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),bigLength + 7,noun1Length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),noun1Length + 22,itemLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),itemLength + 25,emotionLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),emotionLength + 38,rankingLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableMessage.setSpan(ForegroundColorSpan(Color.RED),rankingLength + 1,noun2Length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        //Display the message with colored text
        madLib.text = spannableMessage

    }
}
