package add.murata.muraken.myapplication_count

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.UrlQuerySanitizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import java.util.*
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    var number:Int = 0

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Q = db.collection("Question")


        // Add a new document with a generated ID

        plus.setOnClickListener{
            if (URLedit.text != null){
                var YouTubeURL = editText.text.toString()
            }
            if (Nameedit.text != null){
                var Name = editText.text.toString()
            }
            if (editText.text != null){
                var editText = editText.text.toString()
            }
            val data1 = hashMapOf(
                "URL" to URLedit,
                "Name" to Nameedit,
                "Text" to editText
            )
            Q.document("DATA1").set(data1)


            //val toMinActivity2Intent = Intent(this, MainActivity2::class.java)
            //startActivity(toMinActivity2Intent)

        }


    }
}