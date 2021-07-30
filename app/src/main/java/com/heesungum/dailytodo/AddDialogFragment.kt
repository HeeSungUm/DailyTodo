package com.heesungum.dailytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.heesungum.dailytodo.databinding.DialogAddBinding

class AddDialogFragment: DialogFragment() {
    private var mBinding: DialogAddBinding? = null
    private val binding get() = mBinding!!
    private lateinit var todoViewModel: TodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_add, container, false)
        todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
        mBinding!!.viewModel = todoViewModel
        return binding.root
    }
}