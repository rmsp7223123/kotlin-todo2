package com.example.kotlin_todo2.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_todo2.data.UserDao
import com.example.kotlin_todo2.model.User

// repository는 데이터들을 접근하는 코드들을 모아 둘 때 유용
class UserRepository(private val userDao: UserDao) { // 데이터베이스 작업을 수행하기 위해 Room 데이터베이스와 상호 작용하는 데 사용되는 DAO

    val readAllData: LiveData<List<User>> = userDao.readAllData();

    suspend fun addUser(user: User){ // suspend를 붙여준 이유는 coroutine을 사용하기 위함, 코루틴을 사용하여 메인 스레드를 차단하지 않고 비동기 작업을 수행
        userDao.addUser(user); //DAO에서 만들었던 adduser을 실행
    };

    suspend fun updateUser(user : User) {
        userDao.updateUser(user);
    }

};

// UserRepository클래스는 따로 만들지 않아도 되나, 데이터베이스 작업과 UI 레이어 간의 역할을 분리,
// 코드 재사용, 미래에 데이터베이스 작업을 확장하거나 변경해야 할 때 UserRepository 클래스를 수정하여 변경 사항을 쉽게 처리할 수 있음
// 등의 이유로 사용하는게 좋음.
