package io.github.leonidius20.mediaplayer

import android.graphics.Bitmap
import android.net.Uri

data class MediaItem(val title: String, val uri: Uri, val image: Bitmap?)
