package openchina.sunxun.com.findfrgment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import openchina.sunxun.com.findfrgment.fragment.FragmentFind;
import openchina.sunxun.com.findfrgment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fl_id,new FragmentFind());//添加fragment
        fragmentTransaction.commit();//提交
    }
}
