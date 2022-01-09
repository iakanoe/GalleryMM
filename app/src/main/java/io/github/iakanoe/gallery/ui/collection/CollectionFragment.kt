package io.github.iakanoe.gallery.ui.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.iakanoe.gallery.R
import io.github.iakanoe.gallery.databinding.CollectionFragmentBinding
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.ui.MainActivity
import io.github.iakanoe.gallery.ui.common.ClickableListAdapter

@AndroidEntryPoint
class CollectionFragment : Fragment(), ClickableListAdapter.OnItemClickListener<Album> {

    private val viewModel: CollectionViewModel by viewModels()
    private var binding: CollectionFragmentBinding? = null
    private val adapter = CollectionAdapter(this)

    override fun onStart() {
        super.onStart()
        viewModel.loadCollection()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = CollectionFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.apply {
            adapter = this@CollectionFragment.adapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        lifecycleScope.launchWhenResumed {
            viewModel.getState().collect { applyNewState(it) }
        }
    }

    private fun applyNewState(state: CollectionViewModel.State) = binding?.run {
        loadingSpinner.visibility = View.GONE
        recyclerView.visibility = View.GONE
        errorLabel.visibility = View.GONE

        when (state) {
            CollectionViewModel.State.Error -> errorLabel.visibility = View.VISIBLE
            CollectionViewModel.State.Loading -> loadingSpinner.visibility = View.VISIBLE
            is CollectionViewModel.State.Success -> {
                recyclerView.visibility = View.VISIBLE
                adapter.list = state.collection
            }
        }
    }

    override fun onItemClick(item: Album) {
        findNavController().navigate(CollectionFragmentDirections.openAlbum(item))
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.run {
            setTitle(R.string.fragment_collection_title)
            setBackButtonVisibility(false)
        }
    }
}