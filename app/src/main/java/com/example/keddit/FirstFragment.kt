package com.example.keddit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.keddit.common.adapter.NewsAdapter
import com.example.keddit.model.RedditNewsItem

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var newList: RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newList = view.findViewById(R.id.newsList)
        newList.setHasFixedSize(true)
        newList.layoutManager = LinearLayoutManager(context)
        init()

        if (savedInstanceState == null) {
            val news = (1..20).map {
                RedditNewsItem(
                    "author$it",
                    "Title $it",
                    it, // number of comments
                    1457207701L - it * 200, // time
                    "https://placedog.net/200/200",
                    "url"
                )
            }
            (newList.adapter as NewsAdapter).addNews(news)
        }
    }

    fun init() {
        if (newList.adapter == null) {
            newList.adapter = NewsAdapter()
        }
    }
}
