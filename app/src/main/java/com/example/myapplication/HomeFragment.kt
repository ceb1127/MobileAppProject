package com.example.myapplication

import android.os.Bundle
import android.view.*
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentHomeBinding


class HomeFragment: Fragment() {
    val binding by lazy { FragmentHomeBinding.inflate(layoutInflater)}
    private lateinit var rv : RecyclerView
    private lateinit var RecentItemAdapter : Adapter
    private lateinit var favoriteItemAdapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)

        val toolbar : Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)



        //최근 동영상 어댑터 1
        rv = view.findViewById(R.id.item_recent)

        val list_recent = ArrayList<recentItemData>() //임시 데이터
        list_recent.add(recentItemData(null, "70%","한소희","어그로"))
        list_recent.add(recentItemData(null, "70%","한소희","어그로"))
        list_recent.add(recentItemData(null, "70%","한소희","어그로"))
        list_recent.add(recentItemData(null, "70%","한소희","어그로"))
        list_recent.add(recentItemData(null, "70%","한소희","어그로"))

        val adapter1 = RecentItemAdapter(list_recent)
        rv.adapter = adapter1




        //선호 동영상 어댑터 2
        rv = view.findViewById(R.id.item_favorite)

        val list_favorite = ArrayList<favoriteItemData>() //임시 데이터
        list_favorite.add(favoriteItemData(null))
        list_favorite.add(favoriteItemData(null))
        list_favorite.add(favoriteItemData(null))
        list_favorite.add(favoriteItemData(null))
        list_favorite.add(favoriteItemData(null))

        val adapter2 = FavoriteItemAdapter(list_favorite)
        rv.adapter = adapter2




        setHasOptionsMenu(true)
        return view

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val searchView = menu.findItem(R.id.menu_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                val text = view?.findViewById(R.id.text) as TextView
                text.text = "$p0"
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                val text = view?.findViewById(R.id.text) as TextView
                text.text = "$p0"
                return true
            }
        })
        //return true

    }
}

