package com.funmilola.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaderFragment extends Fragment {

    private LeaderAdapter mLeaderAdapter;

    public LearningLeaderFragment() {
        // Required empty public constructor
    }

    RecyclerView recycler_item_leader;
    List <LearningModel> itemList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_leader, container, false);

        recycler_item_leader = view.findViewById(R.id.recycler_view_first);

        RetrofitEndPointInterface endPointInterface = BaseURLRetrofit.getLeaderApi().create(RetrofitEndPointInterface.class);
        Call<List<LearningModel>> call = endPointInterface.getLearningLeader();
        call.enqueue(new Callback<List<LearningModel>>() {
            @Override
            public void onResponse(Call<List<LearningModel>> call, Response<List<LearningModel>> response) {
             if(response.isSuccessful()){
                 List<LearningModel>modelResponses = response.body();
                 recycler_item_leader.setHasFixedSize(true);
                 recycler_item_leader.setLayoutManager(new LinearLayoutManager(getContext()));
                 mLeaderAdapter = new LeaderAdapter(MainActivity.sContext, modelResponses);
                 recycler_item_leader.setAdapter(mLeaderAdapter);
             }
            }

            @Override
            public void onFailure(Call<List<LearningModel>> call, Throwable t) {
                Toast.makeText(getContext(), "unsuccessful" + t.toString(), Toast.LENGTH_SHORT).show();
                Log.e("unsuccessful","unsuccessful" + t.toString());
            }
        });




        return view;
    }


}