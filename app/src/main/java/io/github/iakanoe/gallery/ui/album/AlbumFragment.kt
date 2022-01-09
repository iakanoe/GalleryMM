package io.github.iakanoe.gallery.ui.album

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.iakanoe.gallery.R
import io.github.iakanoe.gallery.databinding.AlbumFragmentBinding
import io.github.iakanoe.gallery.domain.model.Photo
import io.github.iakanoe.gallery.ui.common.ClickableListAdapter

@AndroidEntryPoint
class AlbumFragment : Fragment(), ClickableListAdapter.OnItemClickListener<Photo> {
    private val viewModel: AlbumViewModel by viewModels()
    private var binding: AlbumFragmentBinding? = null
    private val adapter = AlbumAdapter(this)
    private val args: AlbumFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.setTitle(R.string.fragment_album_title)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadAlbum(args.album)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AlbumFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.apply {
            adapter = this@AlbumFragment.adapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

        lifecycleScope.launchWhenResumed {
            viewModel.getState().collect { applyNewState(it) }
        }
    }

    private fun applyNewState(state: AlbumViewModel.State) = binding?.run {
        loadingSpinner.visibility = View.GONE
        recyclerView.visibility = View.GONE
        errorLabel.visibility = View.GONE

        when (state) {
            AlbumViewModel.State.Error -> errorLabel.visibility = View.VISIBLE
            AlbumViewModel.State.Loading -> loadingSpinner.visibility = View.VISIBLE
            is AlbumViewModel.State.Success -> {
                recyclerView.visibility = View.VISIBLE
                adapter.list = state.album.photos
            }
        }
    }

    override fun onItemClick(item: Photo) {
        findNavController().navigate(AlbumFragmentDirections.openPhotoDetails(item))
    }
}