package add.murata.muraken.myapplication_count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countText.text="0"
        plus.setOnClickListener{
            number += 1
            countText.text=number.toString()
        }
        minse.setOnClickListener{
            number -= 1
            countText.text=number.toString()
        }
    }
}