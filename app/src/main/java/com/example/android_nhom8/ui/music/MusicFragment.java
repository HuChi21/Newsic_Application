package com.example.android_nhom8.ui.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android_nhom8.databinding.FragmentMusicBinding;
import com.example.android_nhom8.ui.news.NewsActivity;

public class MusicFragment extends Fragment {

    private FragmentMusicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMusicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent intent = new Intent(getActivity(), MusicActivity.class);
        startActivity(intent);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}