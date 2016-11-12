package openchina.sunxun.com.findfrgment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuxianedu.wxhlcorelibrary.network.RequestManager;

import java.util.ArrayList;
import java.util.List;

import openchina.sunxun.com.findfrgment.R;
import openchina.sunxun.com.findfrgment.adapter.FindAdapter;

/**
 * Created by Administrator on 2016/10/18.
 */
public class FragmentFind extends Fragment {

    private boolean isLoad = true;//是否进行网络加载
    private RequestManager requestManager;

    /**
     * 绑定布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_find,container,false);
        return view;
    }

    /**
     * 绑定组件
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_id);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_id);

        List<String> titleList = new ArrayList<>();//标题list
        requestManager = RequestManager.getInstance(getActivity());

        titleList.add("推荐项目");
        titleList.add("热门项目");
        titleList.add("最新更新");
        List<Fragment> fragmentList = new ArrayList<>();//fragment
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new HotFragment());
        fragmentList.add(new NewFragment());
        //开始不对热门、最新进行网络加载
        requestManager.cancelRequest("NewFragment");
        requestManager.cancelRequest("HotFragment");
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
       /* //为TabLayout添加tab名称
        for (int i = 0; i < titleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }*/
        FindAdapter adapter = new FindAdapter(getActivity().getSupportFragmentManager(),titleList,fragmentList);
        //viewpager加载adapter
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页面被选中
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                switch (position){
                    case 0://推荐
                        requestManager.cancelRequest("NewFragment");
                        requestManager.cancelRequest("HotFragment");
                        break;
                    case 1://热门
                        requestManager.cancelRequest("RecommendFragment");
                        requestManager.cancelRequest("NewFragment");
                        break;
                    case 2://最新
                        requestManager.cancelRequest("RecommendFragment");
                        requestManager.cancelRequest("HotFragment");
                        break;
                }
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //TabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);
        super.onViewCreated(view, savedInstanceState);
    }
}
