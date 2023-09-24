package com.example.kotlin_todo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kotlin_todo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        setSupportActionBar(binding.toolbar);
        setupActionBarWithNavController(findNavController(R.id.fragment)); // Navigation Component와 ActionBar를 통합
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment); // id가 fragment에서 navcontroller를 찾음
        return navController.navigateUp() || super.onSupportNavigateUp();
        // navController를 사용하여 현재 프래그먼트 간의 탐색을 관리
        // navigateUp 메서드는 뒤로 가기 동작을 수행
        // 현재 화면이 스택에 더 이전 탐색 기록이 있을 경우 이전 화면으로 이동하고, 이전 탐색 기록이 없을 경우 액티비티를 종료
        // onSupportNavigateUp 메서드가 true를 반환하면 현재 액티비티가 뒤로 가기 동작을 처리했음을 나타내며,
        // super.onSupportNavigateUp()를 호출하여 기본 동작을 실행
    };
    // onSupportNavigateUp 메서드는 Navigation Component와 연동하여 현재 액티비티의 뒤로 가기 동작을 처리하고,
    // 해당 동작이 성공적으로 처리되면 true를 반환하며, 그렇지 않으면 기본 동작을 실행
}