
package com.zhisimina.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.zhisimina.listviewtest.arrayadapter.ArrayActivity;
import com.zhisimina.listviewtest.baseadapter.BaseActivity;
import com.zhisimina.listviewtest.simpleadapter.SimpleActivity;

public class MainActivity extends AppCompatActivity {


    TextView mTvArrayAdapter,mTvSimpleAdapter,mTvBaseAdapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window.getDefaultFeatures(this);
        WindowManager.LayoutParams.mayUseInputMethod(2);


        mTvArrayAdapter = (TextView) findViewById(R.id.tv_atvt_main_arrayadapter);
        mTvSimpleAdapter = (TextView) findViewById(R.id.tv_atvt_main_simpleadapter);
        mTvBaseAdapter = (TextView) findViewById(R.id.tv_atvt_main_baseadapter);
        int width = mTvArrayAdapter.getMeasuredWidth();
        int height  = mTvArrayAdapter.getMeasuredHeight();



        mTvArrayAdapter.setOnClickListener(onClickListener);
        mTvSimpleAdapter.setOnClickListener(onClickListener);
        mTvBaseAdapter.setOnClickListener(onClickListener);


    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_atvt_main_arrayadapter:
                    intent = new Intent(MainActivity.this, ArrayActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_atvt_main_simpleadapter:
                    intent = new Intent(MainActivity.this, SimpleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_atvt_main_baseadapter:
                    intent = new Intent(MainActivity.this, BaseActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
