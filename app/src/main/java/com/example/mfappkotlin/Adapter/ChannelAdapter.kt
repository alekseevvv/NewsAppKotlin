package com.example.mfappkotlin.Adapter.ChannelAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mfappkotlin.Model.Article
import com.example.mfappkotlin.Model.Source
import com.example.mfappkotlin.R
import kotlinx.android.synthetic.main.channel_item.view.*

class ChannelAdapter(val newsList: ArrayList<Source>) :

    RecyclerView.Adapter<ChannelAdapter.HomePageViewHolder>() {
    class HomePageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.channel_item, parent, false)
        return HomePageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.view.source.text =  newsList[position].name
        holder.view.desc.text = newsList[position].description
      //  holder.view.homePageImageView.downloadFromUrl(newsList[position].urlToImage, placeHolderProgressBar(holder.view.context))

       /* var people=newsList[position].url
        var title=newsList[position].title
        var date =newsList[position].publishedAt
        var news =newsList[position].content
        var image=newsList[position].urlToImage
*/
        holder.view.setOnClickListener {

        }
    }


    fun updateCountryList(newCountryList: List<Source>) {
        newsList.clear()
        newsList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}

