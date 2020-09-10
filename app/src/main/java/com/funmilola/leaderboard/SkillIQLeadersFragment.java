package com.funmilola.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIQLeadersFragment extends Fragment {


    private SkillAdapter mSkillAdapter;

    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }

    RecyclerView recycler_item_skill;
    List <SkillModelResponse> itemList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);

     recycler_item_skill = view.findViewById(R.id.recycler_view_second);



        RetrofitEndPointInterface endPointInterface = BaseURLRetrofit.getLeaderApi().create(RetrofitEndPointInterface.class);
        Call<List<SkillModelResponse>> call = endPointInterface.getSkillLeader();
        call.enqueue(new Callback<List<SkillModelResponse>>() {
            @Override
            public void onResponse(Call<List<SkillModelResponse>> call, Response<List<SkillModelResponse>> response) {
                List<SkillModelResponse>modelResponses = response.body();
                recycler_item_skill.setHasFixedSize(true);
                recycler_item_skill.setLayoutManager(new LinearLayoutManager(getContext()));

                mSkillAdapter = new SkillAdapter(MainActivity.sContext, modelResponses);

                recycler_item_skill.setAdapter(mSkillAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillModelResponse>> call, Throwable t) {
                Toast.makeText(getContext(), "unsuccessful" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}