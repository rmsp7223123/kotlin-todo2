package com.example.kotlin_todo2.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_todo2.R
import com.example.kotlin_todo2.databinding.FragmentListBinding
import com.example.kotlin_todo2.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding;

    lateinit var mUserViewModel: UserViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater);

        val view = inflater.inflate(R.layout.fragment_list, container, false);

        // 리사이클러뷰
        val adapter = ListAdapter();
        val recyclerView = binding.recyclerview;
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(requireContext());

        // 뷰모델 연결
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java];
        // ViewModelProvider를 사용하여 UserViewModel 클래스의 인스턴스를 초기화하고 mUserViewModel 변수에 저장
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->
            // UserViewModel.readAllData를 관찰하여 사용자 데이터베이스에서 데이터를 가져옴
            // 데이터가 변경되면 관찰자(Observer)가 호출되고, 어댑터의 데이터 업데이트를 통해 리사이클러뷰에 데이터가 표시
            adapter.setData(user);
        })

        // FloatingActionButton에 대한 클릭 리스너 설정
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
            .setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addFragment2);
            };

        setHasOptionsMenu(true); // 메뉴 추가 , Fragment가 옵션 메뉴를 가지고 있음을 나타냄

        return binding.root;
    }
}