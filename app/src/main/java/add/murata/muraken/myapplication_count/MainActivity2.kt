package add.murata.muraken.myapplication_count

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Loads [MainFragment].
 */
class MainActivity2 : FragmentActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                //.replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }


    }
}