@file:Suppress("DEPRECATION")

package com.example.mfappkotlin.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mfappkotlin.Adapter.ChannelAdapter.ChannelAdapter
import com.example.mfappkotlin.HViewModel
import com.example.mfappkotlin.R
import kotlinx.android.synthetic.main.fragment_main.*

class ChannelFragment : Fragment() {

    companion object {
        fun newInstance() = ChannelFragment()
    }

    private lateinit var viewModel: HViewModel
    val newsAdapter = ChannelAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(HViewModel::class.java)
        viewModel.getSourceApı()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeLiveData()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = newsAdapter

        recyclerLine()
    }

    private fun observeLiveData() {
        viewModel.sour.observe(viewLifecycleOwner, Observer { sour ->
            sour?.let {
                recyclerView.visibility = View.VISIBLE
                newsAdapter.updateCountryList(sour)
            }
        })
    }

    private fun recyclerLine() {
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}
