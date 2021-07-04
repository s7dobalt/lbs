package com.example.lbsapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // position = tab
        switch (position) {
            case 0: return new FirstFragment();
            case 1: return new SecondFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2; // so viele Tabs gibt es
    }
}
