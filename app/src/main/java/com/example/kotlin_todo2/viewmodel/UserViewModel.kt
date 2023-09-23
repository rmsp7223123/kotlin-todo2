package com.example.kotlin_todo2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_todo2.data.UserDatabase
import com.example.kotlin_todo2.model.User
import com.example.kotlin_todo2.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) { // AndroidViewModel을 상속받는 Android ViewModel 클래스
    // Android 애플리케이션 컨텍스트를 가져와 사용할 수 있는 ViewModel 클래스

    private val readAllData : LiveData<List<User>>; // LiveData 형식의 사용자 데이터 목록을 저장하는 LiveData 변수
    // LiveData는 관찰 가능한 데이터 객체로서, 데이터가 변경될 때 UI를 업데이트하는 데 사용

    private val repository : UserRepository; // UserRepository 클래스의 인스턴스를 저장하는 변수

    init { // init 함수는 매개변수가 없고 반환되는 값이 없음, 생성자를 통해 인스턴스가 만들어 질 때 호출됨
        val userDao = UserDatabase.getDatabase(application).userDao(); // 데이터베이스 인스턴스를 가져온 다음, UserDao를 얻어옴
        repository = UserRepository(userDao); // UserRepository 인스턴스를 초기화
        readAllData = repository.readAllData; // readAllData LiveData를 초기화, LiveData는 UI에서 사용자 목록을 관찰하는 데 사용
    };

    fun addUser(user: User){ // 사용자를 추가하는 작업
        viewModelScope.launch(Dispatchers.IO) { // 새로운 코루틴 활성화 dispatcherIO는 백그라운드에서 실행
            repository.addUser(user); // 사용자를 데이터베이스에 추가
        };
    };

};