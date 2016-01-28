package edu.rosehulman.rodrigr1.comicviewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class ComicsPagerAdapter extends FragmentPagerAdapter {

    private final int [] colors = {android.R.color.holo_green_light,
            android.R.color.holo_blue_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light};

    private List<ComicWrapper> mComicWrappers;

    public void addComic(){
        mComicWrappers.add(new ComicWrapper(colors[mComicWrappers.size()%colors.length]));
        notifyDataSetChanged();
    }

    public ComicsPagerAdapter(FragmentManager fm, List<ComicWrapper> cws) {
        super(fm);
        if (cws == null){
            mComicWrappers = new ArrayList<>();
            for (int i=0;i<5;i++)
                mComicWrappers.add(new ComicWrapper(colors[i%colors.length]));
        } else {
            mComicWrappers = cws;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return ComicFragment.newInstance(mComicWrappers.get(position));
    }

    @Override
    public int getCount() {
        return mComicWrappers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Issue " + mComicWrappers.get(position).getXkcdIssue();
    }

}
