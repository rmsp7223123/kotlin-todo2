package com.example.kotlin_todo2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


// 데이터베이스를 접근할때 dao를 사용
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)//같은 데이터가 있으면 무시
    suspend fun addUser(user:User); //suspend:코루틴사용 해서 user추가 (매개변수 user는 추가할 사용자의 정보)
    // 코루틴은 코루틴이 시작된 스레드를 중단하지 않으면서 비동기적으로 실행되는 코드
    // 코루틴은 기본적으로 일시중단이 가능
    // suspend fun -> 일반적으로 비동기 작업을 수행
    //                작업이 필요할 때 중단할 수 있으며, 이후 다시 재개할 수 있음, 중단된 코루틴은 다른 코루틴이 실행될 때까지 기다릴 수 있음
    // https://velog.io/@heetaeheo/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%A3%A8%ED%8B%B4%EC%9D%B4%EB%9E%80 (코루틴 참고용)


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>;
};