package com.funmilola.leaderboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    private Context mContext;

    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs, Context context) {
        super(fm);
        this.numOfTabs = numOfTabs;
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearningLeaderFragment();
            case 1:
                return new SkillIQLeadersFragment();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
            return mContext.getString(R.string.learning_leader);
            case 1:
                return mContext.getString(R.string.skill_iq_leaders);
            default:
            return null;
        }
    }
}
