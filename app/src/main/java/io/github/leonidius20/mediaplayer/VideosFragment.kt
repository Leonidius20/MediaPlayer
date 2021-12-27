package io.github.leonidius20.mediaplayer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.CodeBoy.MediaFacer.MediaFacer
import com.CodeBoy.MediaFacer.VideoGet
import io.github.leonidius20.mediaplayer.databinding.MediaListFragmentBinding

class VideosFragment: Fragment() {

    private var _binding: MediaListFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = MediaListFragmentBinding.inflate(inflater, container, false)

        val allVideos = MediaFacer
            .withVideoContex(context)
            .getAllVideoContent(VideoGet.externalContentUri).map {
                MediaItem(it.videoName, Uri.parse(it.assetFileStringUri), null)
            }

        Toast.makeText(context, "Loaded " + allVideos.size, Toast.LENGTH_SHORT).show()

        binding.listView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MediaListAdapter(allVideos.toTypedArray()) {
                val intent = Intent(context, FullscreenActivity::class.java)
                intent.data = it.uri
                startActivity(intent)
            }
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}