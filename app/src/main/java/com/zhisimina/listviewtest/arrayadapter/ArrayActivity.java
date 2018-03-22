package com.zhisimina.listviewtest.arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhisimina.listviewtest.R;

public class ArrayActivity extends AppCompatActivity {

    ListView mLvArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        initView();
        initData();


    }

    private void initData() {
        String[] array = {"张三","张四","张五","张六","张七","张八","张九","李四","李五","王五","王六","王七","王八"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,array);
        mLvArray.setAdapter(arrayAdapter);


    }

    private void initView() {
        mLvArray = (ListView) findViewById(R.id.lv_array);
    }
}
