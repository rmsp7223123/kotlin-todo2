package com.example.kotlin_todo2.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize


// @Entity annotation을 붙여주었기때문에, Room database가 이 dataclass가 Entity라는 걸 인식
@Entity(tableName = "user_table") // 테이블 이름 설정
@VersionedParcelize
data class User (
    @PrimaryKey(autoGenerate = true) // pk인 id는 자동으로 만들게
    val id : Int, // 컬럼1
    // @ColumnInfo(name = "firstName") , @ColumnInfo를 따로 주지않을경우 변수명이 컬럼이름이 됨
    val firstName:String, // 컬럼2
    val lastName:String, // 컬럼3
    val age:Int // 컬럼4
) : Parcelable {
    // Parcelable 인터페이스 메서드 구현
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

};