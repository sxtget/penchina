package sunxun.com.recycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sunxun.com.recycle.divider.DividerGridItemDecoration;
import sunxun.com.recycle.divider.DividerItemDecoration;

/**
 * RecyclerView的使用
 * 1.通过依赖将v7包下的RecyclerView加入项目
 * 2.在xml中使用，像一般控件使用
 * 3.给RecyclerView设置Adapter  ：继承给RecyclerView下的Adapter<ViewHolder>  --->ViewHolder是RecyclerView下的ViewHolder
 *
 * 添加动画
 * 切换
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private List<String> list;
    private RecyclerView recyclerView;
    private DividerItemDecoration dividerItemDecoration;
    private DividerGridItemDecoration dividerGridItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.rv_id);
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分隔符
        dividerGridItemDecoration = new DividerGridItemDecoration(this);
        dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(dividerItemDecoration);


        //为recyclerView增加子条目增删的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        list = initData();
        adapter = new MyAdapter(this,list);

        //设置ItemView的点击事件
        adapter.setOnRecyclerViewItemViewListener(new RecyclerViewItemViewListener() {
            @Override
            public void onClickListener(RecyclerView.ViewHolder viewHolder, int position) {
                Toast.makeText(MainActivity.this, "点击item的position:"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickListener(RecyclerView.ViewHolder viewHolder, int position) {
                Toast.makeText(MainActivity.this, "长按点击item的position:"+position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_id://添加数据
                list.add(0,"Android81");
                adapter.setList(list,0,true);
                break;
            case R.id.delete_id://删除数据
                list.remove(0);
                adapter.setList(list,0,false);
                break;
            case R.id.grid_view_id://GridView网格
                recyclerView.removeItemDecoration(dividerItemDecoration);
                recyclerView.addItemDecoration(dividerGridItemDecoration);
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.list_view_id://ListView垂直
                recyclerView.removeItemDecoration(dividerGridItemDecoration);
                recyclerView.addItemDecoration(dividerItemDecoration);
                recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                break;
            case R.id.staggeredGrid_v_id://StaggeredGridLayoutManager垂直
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.staggeredGrid_h_id://StaggeredGridLayoutManager水平
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 数据源
     * @return
     */
    private List<String> initData(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("无限互联_"+i);
        }
        return list;
    }
}

