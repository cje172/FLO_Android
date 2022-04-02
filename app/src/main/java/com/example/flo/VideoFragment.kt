package com.example.flo

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentDetailBinding
import com.example.flo.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {

    lateinit var binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoBinding.inflate(inflater, container, false)

//        var videoUri: Uri = Uri.parse("https://www.youtube.com/watch?v=86BST8NIpNM")
//        binding.videoVideo01Vv.setVideoURI(videoUri)
//        binding.videoVideo01Vv.setMediaController(MediaController(this.context))
//        binding.videoVideo01Vv.requestFocus()


        return binding.root
    }
}