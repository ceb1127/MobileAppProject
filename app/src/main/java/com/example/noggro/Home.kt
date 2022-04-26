package com.example.noggro

import android.os.Bundle
import android.view.*
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.noggro.databinding.FragmentHomeBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [remove.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    val binding by lazy {FragmentHomeBinding.inflate(layoutInflater)}
    private lateinit var rv : RecyclerView
    private lateinit var RecentItemAdapter : Adapter
    private lateinit var favoriteItemAdapter: Adapter
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment remove.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}










