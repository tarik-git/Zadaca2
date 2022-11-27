package com.example.zadaca2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zadaca2.databinding.FragmentMyShowsBinding;

public class MyShowsFragment extends Fragment {

    private static final String TAG = "MyShowsFragment";

    private FragmentMyShowsBinding binding;

    public MyShowsFragment() {
        // Required empty public constructor
    }

    public static MyShowsFragment newInstance() {
        MyShowsFragment fragment = new MyShowsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentMyShowsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.myShowsTitleTextView.setText(TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}