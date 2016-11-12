package openchina.sunxun.com.findfrgment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.wuxianedu.wxhlcorelibrary.api.EloadType;
import com.wuxianedu.wxhlcorelibrary.network.RequestManager;
import com.wuxianedu.wxhlcorelibrary.utils.NetWorkUtils;
import com.wuxianedu.wxhlcorelibrary.utils.T;
import com.wuxianedu.wxhlcorelibrary.widget.RefreshLayout;
import com.wuxianedu.wxhlcorelibrary.widget.TipInfoLayout;

import java.util.ArrayList;
import java.util.List;

import openchina.sunxun.com.findfrgment.R;
import openchina.sunxun.com.findfrgment.adapter.RecommendFragmentAdapter;
import openchina.sunxun.com.findfrgment.bean.Featured;

/**
 * Created by Administrator on 2016/10/20.
 */
public abstract class MyFragment extends Fragment implements RefreshLayout.OnLoadListener, SwipeRefreshLayout.OnRefreshListener {

    protected RefreshLayout refrshLayout;
    protected List<Featured> inItList = new ArrayList<>();
    protected TipInfoLayout tipInfoLayout;
    protected int current= 1;
    protected RecommendFragmentAdapter adapter;
    protected int firstSize;
    protected int refrshSize;
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

        View view =  inflater.inflate(R.layout.item_view,container,false);
        return view;
    }

    /**
     * 绑定组件
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final ListView listView = (ListView) view.findViewById(R.id.lv_id);
        /**
         * 填充数据，inItList初始为空
         */
        adapter = new RecommendFragmentAdapter(getActivity(),inItList);
        listView.setAdapter(adapter);
        /**
         * 使用requestManager工具类进行网络请求
         */
        requestManager = RequestManager.getInstance(getActivity());

        tipInfoLayout = (TipInfoLayout) view.findViewById(R.id.til_id);
        /**
         * 判读网络状态
         */
        tipInfoLayout.setLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetWorkUtils.initNetStatus(getActivity());

                if(!NetWorkUtils.NETWORK){//无网络

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tipInfoLayout.setNetworkError();
                            Toast.makeText(getContext(), "无可用网络", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();

        //绑定自定义组件（上拉下拉刷新数据）
        refrshLayout = (RefreshLayout) view.findViewById(R.id.rl_id);
        //加载监听
        refrshLayout.setOnLoadListener(this);
        //刷新监听
        refrshLayout.setOnRefreshListener(this);
        /**
         * 第一次加载
         */
        refreshData(EloadType.FIRST);
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 上下拉刷新数据
     */
    private void refreshData(final EloadType type){

        String url = getUrl();

        switch (type){

            case FIRST://首次加载
                break;
            case REFRESH://刷新

                url = url + "?page=" + 1;
                break;
            case PAGE://分页加载

                current++;
                url = url + "?page=" + current;
                break;
        }

        requestManager.getString(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response != null){

                    List<Featured> featuredList = JSON.parseArray(response,Featured.class);
                    switch (type){

                        case FIRST://首次加载
                            //加载完成，隐藏TipInfoLayout
                            tipInfoLayout.completeLoading();
                            //刷新adapter中List数据
                            adapter.setData(featuredList);
                            firstSize = adapter.getCount();//第一次加载的数据个数
                            refrshLayout.setRefreshing(false);//不刷新
                            break;
                        case REFRESH://下拉刷新
                            //加载完成，隐藏TipInfoLayout
                            tipInfoLayout.completeLoading();
                            refrshLayout.setRefreshing(false);

                            refrshSize = featuredList.size();
                            if(refrshSize == firstSize){
                                refrshLayout.setRefreshing(false);
                                T.showShort(getActivity(),"无数据更新");
                            }else{
                                //将更新的数据加在第0个位置
                                adapter.addAll(0,featuredList);
                                T.showShort(getActivity(),"更新成功");
                                refrshLayout.setRefreshing(false);
                            }
                            break;
                        case PAGE://上拉刷新
                            tipInfoLayout.completeLoading();
                            refrshLayout.setLoading(false);
                            if (featuredList.size() != 0) {
                                adapter.addAll(adapter.getCount(), featuredList);
                                T.showShort(getActivity(), "更新成功");

                            } else {
                                T.showShort(getActivity(), "暂无数据更新");
                            }
                            break;
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        },getClassName());
    }
    /**
     * 分页加载
     */
    @Override
    public void onPageLoad() {
        refreshData(EloadType.PAGE);
    }
    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        refreshData(EloadType.REFRESH);
    }

    /**
     * 获取Url
     * @param url
     * @return
     */
    public  abstract String getUrl();

    /**
     * 获取进行请求网络数据的类名
     * @return
     */
    public  abstract String getClassName();
}
