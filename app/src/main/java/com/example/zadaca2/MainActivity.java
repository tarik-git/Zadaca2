package com.example.zadaca2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.zadaca2.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFragment(MyShowsFragment.newInstance());
        binding.bottomNavigationView.setSelectedItemId(R.id.menu_item_my_shows);
        binding.bottomNavigationView.setOnItemSelectedListener(this::onItemSelectedListener);
    }

    private boolean onItemSelectedListener(@NonNull MenuItem item) {
        Fragment fragment;
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_my_shows) {
            fragment = MyShowsFragment.newInstance();
        } else if (itemId == R.id.menu_item_discover) {
            fragment = DiscoverFragment.newInstance();
        } else if (itemId == R.id.menu_item_status) {
            fragment = StatusFragment.newInstance();
        } else {
            fragment = null;
        }

        if (fragment != null) {
            setupFragment(fragment);
            return true;
        } else {
            return false;
        }

    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}