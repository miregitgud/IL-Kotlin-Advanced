package com.example.kotlinadvanced.navfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinadvanced.databinding.FragmentViewmodelBinding
import com.example.kotlinadvanced.viewmodel.MyViewModel

class ViewModelFragment : Fragment() {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: FragmentViewmodelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewmodelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.data.observe(viewLifecycleOwner, Observer {
            // Update UI with the new data
            binding.textView.text = it
        })

        binding.updateButton.setOnClickListener {
            viewModel.updateData("New Data")
        }
    }
}
