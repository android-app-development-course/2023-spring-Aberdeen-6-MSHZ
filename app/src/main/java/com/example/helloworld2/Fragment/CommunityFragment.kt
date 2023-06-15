package com.example.helloworld2.Fragment

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommunityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var space = 5
    private val imgs = intArrayOf(R.drawable.baiqieji, R.drawable.baozaifan, R.drawable.changfen, R.drawable.jiangzhuangnai, R.drawable.shaoe)
    private val titles = arrayOf("懒人包鲜嫩白切鸡", "奶奶偷偷给我的配方", "0失败家庭版肠粉", "我做了超好喝", "保姆级烧鹅教程")
    private val headsIcon = intArrayOf(R.drawable.user, R.drawable.user, R.drawable.user, R.drawable.user, R.drawable.user)
    private val usernames = arrayOf("阿呆", "Wacke", "肉团", "加密", "ajia")


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
        val view = inflater.inflate(com.example.helloworld2.R.layout.fragment_community, container, false)
        val communityAdapter = CommunityAdapter()

        val recyclerView1 = view.findViewById<RecyclerView>(R.id.home_item)
        recyclerView1.layoutManager = GridLayoutManager(activity, 2)
        recyclerView1.addItemDecoration(SpaceItemDecoration(space))
        recyclerView1.adapter = communityAdapter

        return view
    }

    inner class CommunityAdapter : RecyclerView.Adapter<CommunityAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(activity).inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.img.setImageResource(imgs[position])
            holder.title.text = titles[position]
            holder.head.setImageResource(headsIcon[position])
            holder.username.text = usernames[position]
        }

        override fun getItemCount(): Int {
            return titles.size
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val img: ImageView = itemView.findViewById(R.id.home_item_img)
            val head: ImageView = itemView.findViewById(R.id.home_item_head)
            val title: TextView = itemView.findViewById(R.id.home_item_title)
            val username: TextView = itemView.findViewById(R.id.home_item_username)
        }
    }

    inner class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = space
            outRect.top = space
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommunityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}