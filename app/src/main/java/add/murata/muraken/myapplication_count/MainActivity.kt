package add.murata.muraken.myapplication_count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var number:Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data class ScoreItem(val name: String = "",
                             val score: Long = 0,
                             val missCount: Int = 0,
                             val time: Long = 0,
                             val registerTime: Date = Date())

        val db = FirebaseFirestore.getInstance()
        val user = ScoreItem("ken",100,0,30, Date())
        db.collection("ranking")
            .document()
            .set(user)

        context.text="0"
        plus.setOnClickListener{
            number += 1
            context.text=number.toString()
        }
        minse.setOnClickListener{
            number -= 1
            context.text=number.toString()
        }
    }
}