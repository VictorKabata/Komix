import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.comix.R
import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.util.EnviromentVariables.Companion.TAG
import com.vickikbt.comix.util.EnviromentVariables.Companion.variant

class RecyclerViewAdapter(val context: Context, private val characters: List<Characters>) :
    RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Marvel API image representation and pathing
        //image= path + variant_name + extension
        //Example: http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73/ + portrait_xlarge.+  jpg

        val imagePath = characters[position].data.results[position].thumbnail.path
        val imageExtension = characters[position].data.results[position].thumbnail.extension
        val imageURL = imagePath + variant + imageExtension

        Log.e(TAG, imageURL)

        holder.tvCharacter.text = characters[position].data.results[position].name
        Glide.with(holder.tvCharacter.context).load(imageURL).into(holder.ivCharacter)

    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvCharacter: TextView = itemView.findViewById(R.id.textView_character)
    val ivCharacter: ImageView = itemView.findViewById(R.id.imageView_character)
}

