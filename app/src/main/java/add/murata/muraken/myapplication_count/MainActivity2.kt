package add.murata.muraken.myapplication_count

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.net.URL

/**
 * Loads [MainFragment].
 */
class MainActivity2 : FragmentActivity() {

    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var number = intent.getStringExtra("VALUE")

        val docRef = db.collection("Questions").document(number.toString())
        docRef.get().addOnSuccessListener { documentSnapshot ->
            URLText.text = documentSnapshot.toObject<URL>().toString()
        }
        plus.setOnClickListener{
            val data1 = hashMapOf(
                "Name" to NameAnswer.text.toString(),
                "Text" to textAnswer.text.toString()
            )
            db.collection("Answers")
                .add(data1)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }


        }


    }
}