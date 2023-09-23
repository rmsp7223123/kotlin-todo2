package com.example.kotlin_todo2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



// @Entity annotation을 붙여주었기때문에, Room database가 이 dataclass가 Entity라는 걸 인식
@Entity(tableName = "user_table") // 테이블 이름 설정
data class User (
    @PrimaryKey(autoGenerate = true) // pk인 id는 자동으로 만들게
    val id : Int, // 컬럼1
    // @ColumnInfo(name = "firstName") , @ColumnInfo를 따로 주지않을경우 변수명이 컬럼이름이 됨
    val firstName:String, // 컬럼2
    val lastName:String, // 컬럼3
    val age:Int // 컬럼4
) {

};