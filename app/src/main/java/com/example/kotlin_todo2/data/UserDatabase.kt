package com.example.kotlin_todo2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_todo2.model.User


// 데이터 테이블을 접근하고 있을 때 메인 엑서스 포인트, 이곳을 통해 디바이스에 있는 데이터를 접근과 수정, 삭제
@Database(entities = [User::class], version = 1, exportSchema = false) // entities = 데이터베이스에 포함된 엔터티(테이블)를 나열
// exportSchema 속성은 데이터베이스 스키마를 내보내는지 여부
abstract class UserDatabase: RoomDatabase() { // RoomDatabase를 확장한 추상 클래스

    abstract fun userDao(): UserDao; // 데이터베이스와 상호 작용하는 데 사용되는 UserDao 인터페이스에 대한 추상 메서드를 선언

    companion object{ // companion object(동반객체) 클래스의 인스턴스를 생성하지 않고도 접근할 수 있는 객체를 정의
        // https://www.bsidesoft.com/8187 (companion object 참고용)
        @Volatile //다른 thread에서 접근 가능하게
        private var INSTANCE: UserDatabase? = null; //  데이터베이스 인스턴스를 저장
        // 인스턴스는 클래스(Class)를 기반으로 생성된 구체적인 객체
        // 클래스는 객체를 만들기 위한 템플릿이며, 실제 데이터와 동작을 포함하는 객체는 클래스를 기반으로 생성

        fun getDatabase(context: Context):UserDatabase{ // 데이터베이스 인스턴스를 반환하는 역할
            // context 매개변수는 데이터베이스 인스턴스를 생성하기 위해 애플리케이션 컨텍스트가 필요
            val tempInstance = INSTANCE;
            if(tempInstance != null){
                return tempInstance; // 이미 인스턴스가 생성된 경우, 해당 인스턴스를 반환
            };
            // 인스턴스가 생성되지 않은 경우, 스레드 안전하게 인스턴스를 생성하고 반환
            synchronized(this){ //synchronized는 새로운 데이터베이스를 instance
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build();
                INSTANCE = instance;
                return instance;
            };
        };
    };
};