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
            val updatedUser = User(args.currentUser.id, firstName, lastName,age.toInt());
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