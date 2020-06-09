import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.comix.R
import com.vickikbt.comix.data.model.Characters

class RecyclerViewAdapter (val context: Context,private val characters: List<Characters>):RecyclerView.Adapter<MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text= characters[position].data.results[position].name
    }

}

class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val tvName: TextView = itemView.findViewById(R.id.textView_name)
}

