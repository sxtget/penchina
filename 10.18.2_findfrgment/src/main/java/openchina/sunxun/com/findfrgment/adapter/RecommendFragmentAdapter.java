package openchina.sunxun.com.findfrgment.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.wuxianedu.wxhlcorelibrary.adapter.BaseCustomAdapter;
import com.wuxianedu.wxhlcorelibrary.widget.RoundImageView;

import java.util.List;

import openchina.sunxun.com.findfrgment.R;
import openchina.sunxun.com.findfrgment.bean.Featured;
import openchina.sunxun.com.findfrgment.bean.Owner;


/**
 * Created by Administrator on 2016/10/19.
 */
public class RecommendFragmentAdapter extends BaseCustomAdapter<Featured> {

    private RequestQueue  requestQueue;

    public RecommendFragmentAdapter(Context mContext, List<Featured> mList) {
        super(mContext, mList);
    }

    @Override
    public View getCustomView(int position, View contentView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(contentView == null){

            viewHolder = new ViewHolder();
            contentView = mLayoutInflater.inflate(R.layout.item_fragment_view,null);
            viewHolder.headImage = (RoundImageView) contentView.findViewById(R.id.head_id);
            viewHolder.name = (TextView) contentView.findViewById(R.id.name_id);
            viewHolder.description = (TextView) contentView.findViewById(R.id.description_id);
            viewHolder.fork = (TextView) contentView.findViewById(R.id.fork_id);
            viewHolder.star = (TextView) contentView.findViewById(R.id.star_id);
            viewHolder.watches = (TextView) contentView.findViewById(R.id.watches_id);
            viewHolder.language = (TextView) contentView.findViewById(R.id.language_id);
            requestQueue = Volley.newRequestQueue(mContext);
            contentView.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) contentView.getTag();
        }

        //1.创建RequestQueue对象

        //利用父类提供的方法获取数据
        Featured featured = getData().get(position);

        Owner owner = featured.getOwner();
        //头像
        String headImage =  owner.getNew_portrait();

        int fork= featured.getForks_count();
        viewHolder.fork.setText(String.valueOf(fork));
        String description = featured.getDescription();
        viewHolder.description.setText(description);
        String name = owner.getName();
        viewHolder.name.setText(name);
        int star = featured.getStars_count();
        viewHolder.star.setText(String.valueOf(star));
        int watch =  featured.getWatches_count();
        viewHolder.watches.setText(String.valueOf(watch));
        String language = featured.getLanguage();
        viewHolder.language.setText(language);

        loadImage(headImage,viewHolder.headImage);
        return contentView;
    }

    class ViewHolder{

        TextView name,description,watches,star,fork,language;
        RoundImageView headImage;
    }

    /**
     * 图片加载
     * @param headImage
     * @param image
     */
    private void loadImage(String headImage,RoundImageView image){



        //2. 创建ImageLoader
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {

            private LruCache<String,Bitmap> lruCache = new LruCache<String,Bitmap>(5*1024*1024){

                //重写sizeof方法
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getHeight();
                }
            };
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url,bitmap);
            }
        });

        //3.获取ImageListener
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(image,R.mipmap.img_header,
                R.mipmap.img_header);

        //4.通过ImageLoader 的get方法进行网络图片加载
        imageLoader.get(headImage,imageListener);
    }
}
