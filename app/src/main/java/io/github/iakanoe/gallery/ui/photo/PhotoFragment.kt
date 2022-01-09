package io.github.iakanoe.gallery.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.github.iakanoe.gallery.R
import io.github.iakanoe.gallery.databinding.PhotoFragmentBinding
import io.github.iakanoe.gallery.ui.MainActivity

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private var binding: PhotoFragmentBinding? = null
    private val args: PhotoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PhotoFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.photo = args.photo
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.run {
            setTitle(R.string.fragment_photo_title)
            setBackButtonVisibility(true)
        }
    }
}