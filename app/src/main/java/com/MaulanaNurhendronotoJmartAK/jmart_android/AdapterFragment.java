package com.MaulanaNurhendronotoJmartAK.jmart_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class AdapterFragment extends FragmentStateAdapter
{
    public AdapterFragment
            (
                    @NonNull FragmentManager fm,
                    @NonNull Lifecycle lifecycle
            )
    {
        super(fm, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        if (position == 1) {
            return new FilterFragment();
        }
        return new ProductFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
