package openchina.sunxun.com.findfrgment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class FindAdapter extends FragmentPagerAdapter {


    private static final String TAG ="--main--" ;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    /**
     * 刷新fragmentList
     * @param fragmentList
     */
    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    public FindAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 获取标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
