package io.github.leonidius20.mediaplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.leonidius20.mediaplayer.databinding.ActivityFullscreenBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullscreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFullscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: storage access framework get video (or context resolver..?)
        // or simply make it open videos from other apps (in mainfest)

        // https://drive.google.com/drive/u/0/folders/1zD7_uncVBBswLtbT2ovWr9nkTJTwhuyD
        // https://developer.android.com/guide/topics/providers/document-provider
    }


}