package com.heesungum.dailytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.heesungum.dailytodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var viewModel: TodoViewModel = TodoViewModel(requireActivity().application)
    private var mBinding: FragmentHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding!!.homeRv.layoutManager = LinearLayoutManager(context)
        mBinding!!.homeRv.adapter = context?.let { TodoRvAdapter(it, viewModel.getTodos()) }
        return binding.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}