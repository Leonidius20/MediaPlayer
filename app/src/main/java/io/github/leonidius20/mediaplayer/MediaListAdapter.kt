package io.github.leonidius20.mediaplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaListAdapter(private val media: Array<MediaItem>, private val onClick: (MediaItem) -> Unit): RecyclerView.Adapter<MediaListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.item_thumbnail)
        val titleTextView = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.video_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val piece = media[position]
        holder.titleTextView.text = piece.title
        // https://square.github.io/picasso/

        if (piece.image != null) {
            holder.imageView.setImageBitmap(piece.image)
        } else {
            holder.imageView.setImageResource(R.drawable.music_placeholder)
        }


        holder.itemView.setOnClickListener { onClick(piece) }
    }

    override fun getItemCount() = media.size

}