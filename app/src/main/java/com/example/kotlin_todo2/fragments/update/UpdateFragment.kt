package com.example.kotlin_todo2.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin_todo2.R
import com.example.kotlin_todo2.databinding.FragmentUpdateBinding
import com.example.kotlin_todo2.model.User
import com.example.kotlin_todo2.viewmodel.UserViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>();
    private lateinit var binding : FragmentUpdateBinding;
    private lateinit var mUserViewModel: UserViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater);
        binding.updateFirstNameEt.setText(args.currentUser.firstName);
        binding.updateLastNameEt.setText(args.currentUser.firstName);
        binding.updateAgeEt.setText(args.currentUser.age.toString());
        val view = inflater.inflate(R.layout.fragment_update, container, false);
        binding.updateButton.setOnClickListener {
            val firstName = view.findViewById<EditText>(R.id.updateFirstName_et).text.toString();
            val lastName = view.findViewById<EditText>(R.id.updateLastName_et).text.toString();
            val age = view.findViewById<EditText>(R.id.updateAge_et).text.toString();
            updateItem(firstName, lastName, age);
        };

        setHasOptionsMenu(true);

        return binding.root;
    }

    private fun updateItem(firstName: String, lastName: String, age: String){
        if (inputCheck(firstName,lastName,age)){

            //updatedUser는 업데이트된 데이터입니다.
            val updatedUser = User(args.currentUser.id, firstName, lastName,age.toInt());

            //updateUser쿼리를 만들어서 Update Query를 이용하여 database에 추가해줘야합니다.
            //Update 쿼리는 DAO에서 추가해야합니다.
            //지금은 viewModel에 update 쿼리가 생기면 updatedUser가 전달되도록 구현만 해놓겠습니다.
            mUserViewModel.updateUser(updatedUser);
            Toast.makeText(requireContext(),"변경완료",Toast.LENGTH_SHORT).show();
            findNavController().navigate(R.id.action_updateFragment_to_listFragment);

        } else{
            Toast.makeText(requireContext(),"변경완료 실패",Toast.LENGTH_SHORT).show();
        };
    };
    private fun inputCheck(firstName:String, lastName:String, age: String):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&& age.isEmpty());
    };
}