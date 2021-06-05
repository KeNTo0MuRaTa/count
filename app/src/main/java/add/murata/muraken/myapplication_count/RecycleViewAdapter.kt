package add.murata.muraken.myapplication_count

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    val items: MutableList<CourseData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_course_data_cell,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.URLTextView.text = item.URL
        holder.NameTextView.text = item.Name
        holder.TextTextView.text = item.text
    }

    fun addAll(items: List<CourseData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val URLTextView: TextView = view.findViewById(R.id.couurseNameTextView)
        val NameTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val TextTextView: TextView = view.findViewById(R.id.textView2)
    }
}