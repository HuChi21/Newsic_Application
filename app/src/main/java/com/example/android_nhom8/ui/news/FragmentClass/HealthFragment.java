package com.example.android_nhom8.ui.news.FragmentClass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_nhom8.ui.news.Adapter;
import com.example.android_nhom8.ui.news.Api.ApiUtilities;
import com.example.android_nhom8.R;
import com.example.android_nhom8.ui.news.mainNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {


    String getAPI = "2784fe81b45f4ad0a94dc4c61f4fbc9f";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="us";
    String catagory="health";
    private RecyclerView recyclerViewHealth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.healthfrag,null);

        recyclerViewHealth=v.findViewById(R.id.recyclerviewHealth);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewHealth.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCatagoryNews(country,catagory,50,getAPI).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });



    }
}
