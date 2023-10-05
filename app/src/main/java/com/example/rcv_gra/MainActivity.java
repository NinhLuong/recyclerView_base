package com.example.rcv_gra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.rcv_gra.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        Để có thể thay đổi nhiều fragment khác nhau nên setContentView bằng getRoot()
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
    }

    private void replaceFragment(Fragment fragment){
//       FragmentManager quản lý các Fragment trong trong layout
//        getSupportFragmentManager trả về các tương tác của fragment đã kết hợp với activy hiện tại
        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction thực hiện việc thay đổi fragment
//        fragmentManager.beginTransaction() trình quản lý Fragment cho phép bắt đầu việc thay thế fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        replace(): thực hiện thay thế FrameLayout ban đầu bằng một fragment truyền vào
        fragmentTransaction.replace(R.id.frameLayout, fragment);
//        commit() xác nhận việc thay thế và kế thúc thay thế fragment
        fragmentTransaction.commit();
    }
}