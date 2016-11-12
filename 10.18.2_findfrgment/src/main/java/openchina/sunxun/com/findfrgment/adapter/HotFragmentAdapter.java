package openchina.sunxun.com.findfrgment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.wuxianedu.wxhlcorelibrary.adapter.BaseCustomAdapter;

import java.util.List;

import openchina.sunxun.com.findfrgment.bean.Featured;

/**
 * Created by Administrator on 2016/10/20.
 */
public class HotFragmentAdapter extends BaseCustomAdapter<Featured> {

    public HotFragmentAdapter(Context mContext, List<Featured> mList) {
        super(mContext, mList);
    }

    @Override
    public View getCustomView(int position, View contentView, ViewGroup parent) {

        return contentView;
    }
}