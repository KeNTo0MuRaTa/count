package add.murata.muraken.myapplication_count

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_recycle_view.*
import java.nio.file.Files.delete
import java.util.*

class MainPage : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_main)

        var number = intent.getStringExtra("VALUE")

        val taskList = readAll()


        // タスクリストが空だったときにダミーデータを生成する
        if (taskList.isEmpty()) {
            createDummyData()
        }

        val adapter =
            TaskAdapter(this, taskList, object : TaskAdapter.OnItemClickListener {
                override fun onItemClick(item: Task) {
                    // クリック時の処理
                    Toast.makeText(applicationContext, item.content + "を削除しました", Toast.LENGTH_SHORT).show()
                    //val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("VALUE", number)
                    startActivity(intent)
                }
            }, true)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter



    }
    val docRef = db.collection("cities").document("SF")

    // Source can be CACHE, SERVER, or DEFAULT.
    val source = Source.CACHE

// Get the document, forcing the SDK to use the offline cache



    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun createDummyData() {
        var number = intent.getStringExtra("VALUE")
        val docRef = db.collection("Questions").document(number.toString())
        docRef.get()
            .addOnSuccessListener {
                    document ->
                if (document != null) {
                    //create(R.drawable.ic_launcher_background, document.data)
                }
        }
    }

    fun create(imageId: Int, content: String) {
        realm.executeTransaction {
            val task = it.createObject(Task::class.java, UUID.randomUUID().toString())
            task.imageId = imageId
            task.content = content
        }
    }

    fun readAll(): RealmResults<Task> {
        return realm.where(Task::class.java).findAll().sort("createdAt", Sort.ASCENDING)
    }

}