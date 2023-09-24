package com.example.kotlin_todo2.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlin_todo2.R
import com.example.kotlin_todo2.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    // private lateinit var mUserViewModel: UserViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false);

        // FloatingActionButton에 대한 클릭 리스너 설정
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
            .setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addFragment2);
            };

        return view;
    }
}