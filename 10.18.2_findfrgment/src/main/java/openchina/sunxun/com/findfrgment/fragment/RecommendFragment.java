package openchina.sunxun.com.findfrgment.fragment;


import com.wuxianedu.wxhlcorelibrary.utils.L;
import com.wuxianedu.wxhlcorelibrary.utils.RequestAPI;

import openchina.sunxun.com.findfrgment.base.MyFragment;

/**
 * Created by Administrator on 2016/10/18.
 */
public class RecommendFragment extends MyFragment {


    @Override
    public String getUrl() {
        String url = RequestAPI.getAbsoluteUrl(RequestAPI.FEATURED);
        return url;
    }

    @Override
    public String getClassName() {

        L.e("RecommendFragment------"+getClass().getName());
        return "RecommendFragment";
    }
}
