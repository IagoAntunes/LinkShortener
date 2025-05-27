package com.iagoaf.linkshortener.features.home.presenter.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.iagoaf.linkshortener.databinding.ActivityMainBinding
import com.iagoaf.linkshortener.features.home.presenter.adapter.MyItemRecyclerViewAdapter
import com.iagoaf.linkshortener.features.home.presenter.state.HomeListener
import com.iagoaf.linkshortener.features.home.presenter.state.HomeState
import com.iagoaf.linkshortener.features.home.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    val binding get() = _binding

    val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: MyItemRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initListeners()
        setupRecyclerView()
        listenState()
        listenListener()
        viewModel.getLinks()

    }

    private fun setupRecyclerView() {
        adapter = MyItemRecyclerViewAdapter(
            values = emptyList(),
            onClickCopy = { link ->
                //
            },
            onClickDelete = { link ->
                viewModel.deleteLink(link.id)
            },
        )
        binding.rcvMyLinks.adapter = adapter
    }

    private fun initListeners() {
        binding.btnCreateLink.setOnClickListener {
            val originalLink = binding.edtOriginalLink.text.toString()
            val shortenedLink = binding.edtShortenedLink.text.toString()
            viewModel.createLink(
                originalLink = originalLink,
                shortLink = shortenedLink,
            )
        }
    }

    private fun listenState() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is HomeState.Error -> {}
                is HomeState.Idle -> {}
                is HomeState.Loading -> {}
                is HomeState.Success -> {
                    adapter.setItems(state.list)
                }
            }
        }
    }

    private fun listenListener() {
        viewModel.listener.observe(this) { listener ->
            when (listener) {
                is HomeListener.Error -> {}
                is HomeListener.Loading -> {}
                is HomeListener.ShowSnackBar -> {}
                is HomeListener.ShowToast -> {}
                is HomeListener.Success -> {
                    binding.edtOriginalLink.text?.clear()
                    binding.edtShortenedLink.text?.clear()
                    viewModel.getLinks()
                }
            }
        }
    }

}