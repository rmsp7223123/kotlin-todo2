package com.example.kotlin_todo2.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_todo2.R
import com.example.kotlin_todo2.model.User
import com.example.kotlin_todo2.viewmodel.UserViewModel

class AddFragment : Fragment() {

    //뷰모델을 이니셜라이즈 해줍니다.
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // add 프라그먼트를 불러옵니다.
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        //뷰모델 프로바이더를 실행해줍니다.
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //버튼을 누르면 insertDataToDatabase가 실행됩ㄴ디ㅏ.
        view.findViewById<Button>(R.id.add_button).setOnClickListener{
            // insertDataToDatabase()
        }

        return view
    }

   /* private fun insertDataToDatabase() {
        //사용자가 입력한 텍스트들을 가져옵니다.
        val firstName = editTextTextPersonName.text.toString()
        val lastName = editTextTextPersonName2.text.toString()
        val age = editTextNumber.text

        if(inputCheck(firstName,lastName,age)){ //inputcheck라는 함수를 만들어주었습니다.
            //유저 오브젝트를 만들어줍니다.이 값이 database에 전송되게 됩니다.

            val user = User(0,firstName, lastName, Integer.parseInt(age.toString()))
            //id가 0인 이유는 우리가 PK를 자동으로 생성되게 만들어도 값을 넣어줘야합니다.

            //뷰모델에 add user를 해줌으로써 데이터베이스에 user값을 넣어주게 됩니다.
            mUserViewModel.addUser(user)

            //토스트 메세지입니다.
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //다시 listfragment로 돌려보냅니다.
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            //만약 유저가 editText모두 넣지 않았다면 토스트 메세지를 띄웁니다.
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    //텍스트박스가 비어있는지 확인합니다.
    private fun inputCheck(firstName:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

    */


}