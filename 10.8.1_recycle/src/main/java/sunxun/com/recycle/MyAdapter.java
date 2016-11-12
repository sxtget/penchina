package sunxun.com.recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terry-song on 2016/10/7.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private static final String TAG ="--main--" ;
    private Context context;
    private List<String> list;
    private List<Integer> heightList;
    private RecyclerViewItemViewListener listener ;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

        heightList = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            int height = (int) (Math.random()*400 + 400);
            heightList.add(height);
        }
    }

    public void setList(List<String> list,int position,boolean isInsert) {
        this.list = list;
//        notifyDataSetChanged();
        if(isInsert){//添加
            notifyItemInserted(position);
        }else{//移除
            notifyItemRemoved(position);
        }
    }

    /**
     * 给itemView监听器赋值
     * @param listener
     */
    public void setOnRecyclerViewItemViewListener(RecyclerViewItemViewListener listener){
        this.listener = listener;
    }

    int i = 0;
    /**
     * 创建ViewHolder对contentView进行复用
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        i++;
        Log.e(TAG, "onCreateViewHolder: -----------i"+i );
        View contentView = LayoutInflater.from(context).inflate(R.layout.activity_main_item,parent,false);
        return new ViewHolder(contentView);
    }

    /**
     * 进行数据绑定，itemView设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int height = heightList.get(position);
        ViewGroup.LayoutParams lp = holder.button.getLayoutParams();
        lp.height = height;
        holder.button.setLayoutParams(lp);

        Log.e(TAG,"----------------onBindViewHolder-----------position："+position);
        holder.button.setText(list.get(position));
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        Button button;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            //为ViewHolder中的组件进行赋值
            button = (Button) itemView.findViewById(R.id.id_but);
            button.setOnClickListener(this);

            if(listener != null){//判断RecyclerViewItemViewListener是否为空，
                                // 若为空，不能给子条目设置点击事件，否则会出现空指针
                itemView.setOnClickListener(this);
                itemView.setOnLongClickListener(this);
            }
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.id_but://按钮的点击事件
//                    Toast.makeText(MainActivity.this, "点击按钮的position:"+position, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.item_id://itemView的点击事件
                    listener.onClickListener(this,position);
//                        Toast.makeText(MainActivity.this, "点击item的position:"+position, Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public boolean onLongClick(View v) {//itemView的长按事件
            listener.onLongClickListener(this,position);
//                Toast.makeText(MainActivity.this, "长按点击item的position:"+position, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}