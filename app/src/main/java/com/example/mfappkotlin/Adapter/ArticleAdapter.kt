package com.example.mfappkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mfappkotlin.DB.Article
import com.example.mfappkotlin.R
import kotlinx.android.synthetic.main.article_item.view.*
import kotlinx.android.synthetic.main.channel_item.view.desc
import kotlinx.android.synthetic.main.channel_item.view.source
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ArticleAdapter(val newsList: ArrayList<Article>) :

    RecyclerView.Adapter<ArticleAdapter.HomePageViewHolder>() {
    class HomePageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.article_item, parent, false)
        return HomePageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.view.publishedAt.text = DateFormat(newsList[position].publishedAt)
        holder.view.source.text = newsList[position].author
        holder.view.desc.text = newsList[position].description
        holder.view.title.text = newsList[position].title
        holder.view.time.text = DateToTimeFormat(newsList[position].publishedAt)
        holder.view.img.downloadFromUrl(newsList[position].urlToImage)

        holder.view.setOnClickListener {

        }
    }

    fun updateCountryList(newCountryList: List<Article>) {
        newsList.clear()
        newsList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    fun ImageView.downloadFromUrl(url: String?) {
        val options = RequestOptions()
            // .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher_round)

        Glide.with(context)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(this)

    }

    fun DateFormat(oldstringDate: String?): String? {
        val newDate: String
        val dateFormat =
            SimpleDateFormat("E, d MMM yyyy", Locale("ru"))
        newDate = try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldstringDate)
            dateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace().toString();

        }
        return newDate
    }

    fun DateToTimeFormat(oldstringDate: String?): String? {
        val p = PrettyTime(Locale("ru"))
        var isTime: String? = null
        try {
            val sdf = SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                Locale.ENGLISH
            )
            val date: Date = sdf.parse(oldstringDate)
            isTime = p.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return isTime
    }
}