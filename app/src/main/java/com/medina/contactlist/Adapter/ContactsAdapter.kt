import android.content.ActivityNotFoundException
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.medina.contactlist.databinding.ItemContactBinding
import com.medina.contactlist.model.Music

class ContactsAdapter(private val dataSet: List<Music>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var Name: TextView = binding.fullnameText
        var nameMusic: TextView = binding.emailText
        var additionalText: ImageView = binding.startMusic
        var btnViewPause: ImageView = binding.btnPause
        var btnViewStart: ImageView = binding.btnStart
        var btnViewShare: ImageView = binding.btnShare
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        val music: Music = this.dataSet[position]
        val context = binding.itemView.context
        val idRes = context.resources.getIdentifier(music.picture, "drawable", context.packageName)

        binding.Name.text = music.name
        binding.nameMusic.text = music.singer
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener {
            Toast.makeText(context,"Género $position", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewPause.setOnClickListener {
            Toast.makeText(context, "Pause ${music.name}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewStart.setOnClickListener {
            Toast.makeText(context, "Play ${music.name}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(Intent.EXTRA_TEXT, "La canción ${music.name} del cantante ${music.singer} " +
                    "su género ${music.category} es genial!")
            try {
                context.startActivity(intent)
            }catch (ex: ActivityNotFoundException){
                Toast.makeText(context, "WhatsApp isn't install in this mobile", Toast.LENGTH_SHORT).show()
            }
        }

        if (music.category == "Rock") {
            binding.additionalText.visibility = View.VISIBLE
        }


    }

    override fun getItemCount(): Int = dataSet.size
}
