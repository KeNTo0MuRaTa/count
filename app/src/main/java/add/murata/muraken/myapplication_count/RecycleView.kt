package add.murata.muraken.myapplication_count

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import add.murata.muraken.myapplication_count.databinding.ActivityRecycleViewBinding
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleView : AppCompatActivity() {

    val courseData: List<CourseData> = listOf(
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

            val adapter = RecyclerViewAdapter(this)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter

            adapter.addAll(courseData)
    }

}