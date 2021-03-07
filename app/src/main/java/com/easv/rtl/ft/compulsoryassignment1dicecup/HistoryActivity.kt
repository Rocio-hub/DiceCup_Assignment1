package com.easv.rtl.ft.compulsoryassignment1dicecup

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.easv.rtl.ft.compulsoryassignment1dicecup.Model.BERoll
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    var arrayListHistory = arrayListOf<BERoll>()
    private var hist = listOf<String>()

    private val diceId = intArrayOf(0, R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        btn_back.setOnClickListener { v -> onClickBack() }
        btn_clear.setOnClickListener { v -> onClickClear() }

        if (intent.extras != null) {
             var extras: Bundle = intent.extras!!
            arrayListHistory = extras.getSerializable("myHistory") as ArrayList<BERoll>

            //set images for the dices in every row
            var defaultX : Float = 480F
            var defaultY : Float = 10F
            for(item in arrayListHistory){
                hist += item.now //+ " "+ item.dice1.toString() + item.dice2.toString() + item.dice3.toString() + item.dice4.toString() + item.dice5.toString() + item.dice6.toString()

                var dice1 = ImageView(this)
                cs_layout.addView(dice1)
                dice1.layoutParams.height = 160
                dice1.layoutParams.width = 160
                dice1.x = defaultX
                dice1.y = defaultY

                var dice2 = ImageView(this)
                cs_layout.addView(dice2)
                dice2.layoutParams.height = 160
                dice2.layoutParams.width = 160
                dice2.x = defaultX + 160
                dice2.y = defaultY

                var dice3 = ImageView(this)
                cs_layout.addView(dice3)
                dice3.layoutParams.height = 160
                dice3.layoutParams.width = 160
                dice3.x = defaultX + 320
                dice3.y = defaultY

                var dice4 = ImageView(this)
                cs_layout.addView(dice4)
                dice4.layoutParams.height = 160
                dice4.layoutParams.width = 160
                dice4.x = defaultX + 480
                dice4.y = defaultY

                var dice5 = ImageView(this)
                cs_layout.addView(dice5)
                dice5.layoutParams.height = 160
                dice5.layoutParams.width = 160
                dice5.x = defaultX + 640
                dice5.y = defaultY

                var dice6 = ImageView(this)
                cs_layout.addView(dice6)
                dice6.layoutParams.height = 160
                dice6.layoutParams.width = 160
                dice6.x = defaultX + 800
                dice6.y = defaultY
                dice1.setImageResource(diceId[item.dice1])
                dice2.setImageResource(diceId[item.dice2])
                dice3.setImageResource(diceId[item.dice3])
                dice4.setImageResource(diceId[item.dice4])
                dice5.setImageResource(diceId[item.dice5])
                dice6.setImageResource(diceId[item.dice6])
                defaultY += 170
            }

            val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(
                this, android.R.layout.simple_list_item_1, hist
            )
            lv_history.adapter = arrayAdapter
        }
    }

    private fun onClickClear() {
        Toast.makeText(this, "History deleted successfully", Toast.LENGTH_SHORT).show()
        setResult(RESULT_CANCELED)
        finish()
    }

    private fun onClickBack() {
        val intent = Intent()
        intent.putExtra("myHistory", arrayListHistory)
        setResult(RESULT_OK, intent)
        finish()
    }
}