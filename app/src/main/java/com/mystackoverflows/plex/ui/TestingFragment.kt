package com.mystackoverflows.plex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mystackoverflows.plex.R

/**
 * A simple [Fragment] subclass.
 * Use the [TestingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testing, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment TestingFragment.
         */
        @JvmStatic
        fun newInstance() =
            TestingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}