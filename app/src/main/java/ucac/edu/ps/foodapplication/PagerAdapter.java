package ucac.edu.ps.foodapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<MyTab> myTabs = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void AddTabs(MyTab tab) {
        myTabs.add(tab);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myTabs.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myTabs.get(position).getCategory().getName();
    }

    @Override
    public int getCount() {
        return myTabs.size();
    }
}
