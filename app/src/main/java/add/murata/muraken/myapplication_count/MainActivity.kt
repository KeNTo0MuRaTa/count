package add.murata.muraken.myapplication_count

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var number:Int = 0

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cities = db.collection("cities")

        // Add a new document with a generated ID
        context.text="0"

        plus.setOnClickListener{
            number += 1
            val data1 = hashMapOf(
                "name" to "San Francisco",
                "state" to "CA",
                "country" to "USA",
                "capital" to false,
                "population" to 860000,
                "regions" to listOf("west_coast", "norcal")
            )
            cities.document("SF").set(data1)

            val data2 = hashMapOf(
                "name" to "Los Angeles",
                "state" to "CA",
                "country" to "USA",
                "capital" to false,
                "population" to 3900000,
                "regions" to listOf("west_coast", "socal")
            )
            cities.document("LA").set(data2)

            val data3 = hashMapOf(
                "name" to "Washington D.C.",
                "state" to null,
                "country" to "USA",
                "capital" to true,
                "population" to 680000,
                "regions" to listOf("east_coast")
            )
            cities.document("DC").set(data3)

            val data4 = hashMapOf(
                "name" to "Tokyo",
                "state" to null,
                "country" to "Japan",
                "capital" to true,
                "population" to 9000000,
                "regions" to listOf("kanto", "honshu")
            )
            cities.document("TOK").set(data4)

            val data5 = hashMapOf(
                "name" to "Beijing",
                "state" to null,
                "country" to "China",
                "capital" to true,
                "population" to 21500000,
                "regions" to listOf("jingjinji", "hebei")
            )
            cities.document("BJ").set(data5)
        }

        minse.setOnClickListener {
            number -= 1
            context.text = number.toString()
            val docRef = db.collection("cities").document("SF")
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    } else {
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }

        }
    }
}