package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo.databinding.FragmentSaveBinding
import com.google.gson.Gson

class SaveFragment : Fragment() {

    lateinit var binding: FragmentSaveBinding
    private var albumDatas = ArrayList<Album>()
    private var gson: Gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)

        val albumJson = arguments?.getString("album")
        val album = gson.fromJson(albumJson, Album::class.java)

        // 데이터 리스트 생성 더머 데이터
        albumDatas.apply {
            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp))
            add(Album("Fool", "WINNER", R.drawable.img_album_exp2))
            add(Album("너를 사랑하고 있어", "백현 (BAEKHYUN)", R.drawable.img_album_exp3))
            add(Album("Next Level", "aespa", R.drawable.img_album_exp4))
            add(Album("낙하 (with 아이유)", "AKMU (악뮤)", R.drawable.img_album_exp5))
            add(Album("LOVE DIVE", "IVE (아이브)", R.drawable.img_album_exp6))
        }

        // 어댑터와 데이터 리스트 연결
        val saveRVAdapter = SaveRVAdapter(albumDatas)
        binding.lockerSaveMusicRv.adapter = saveRVAdapter
        binding.lockerSaveMusicRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        saveRVAdapter.setMyItemClickListener(object : SaveRVAdapter.MyItemClickListener {
            override fun onItemClick(album: Album) {
                changeAlbumFragment(album)
            }

            override fun onRemoveAlbum(position: Int) {
                saveRVAdapter.removeItem(position)
            }
        })

        return binding.root
    }

    private fun changeAlbumFragment(album: Album) {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AlbumFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val albumJson = gson.toJson(album)
                    putString("album", albumJson)
                }
            })
            .commitAllowingStateLoss()
    }

}