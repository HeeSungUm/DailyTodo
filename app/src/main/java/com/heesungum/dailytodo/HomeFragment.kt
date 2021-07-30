package com.heesungum.dailytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.heesungum.dailytodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var mBinding: FragmentHomeBinding? = null
    private val binding get() = mBinding!!
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = context?.let { TodoRvAdapter(it) }
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        activity?.let {
            todoViewModel = ViewModelProvider(it).get(TodoViewModel::class.java)
            mBinding!!.homeRv.layoutManager = LinearLayoutManager(context)
            mBinding!!.homeRv.adapter = adapter
            mBinding!!.lifecycleOwner = viewLifecycleOwner
            mBinding!!.viewModel = todoViewModel
            mBinding!!.activity = activity as MainActivity
        }


        todoViewModel.todos.observe(viewLifecycleOwner, {
            adapter?.setData(it)
        })
        return binding.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}