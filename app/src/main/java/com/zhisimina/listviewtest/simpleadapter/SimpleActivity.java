package com.zhisimina.listviewtest.simpleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zhisimina.listviewtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initView();
        initData();
    }

    ListView mLvSimple;


    private void initData() {
        String[] array1 = {"张三","张四","张五","张六","张七","张八","张九","李四","李五","王五","王六","王七","王八"};
        String[] array2 = {"张三","张四","张五","张六","张七","张八","张九","李四","李五","王五","王六","王七","王八"};
        int[] images = {R.drawable.asdf,R.drawable.haha,R.drawable.maoerha,R.drawable.xian,R.drawable.haha
                ,R.drawable.maoerha,R.drawable.xian,R.drawable.haha,R.drawable.maoerha,R.drawable.xian,
                R.drawable.haha,R.drawable.maoerha,R.drawable.xian};

        List<Map<String , Object>> listItems = new ArrayList<Map<String , Object>>();
        for (int i = 0; i < array1.length; i++) {
            Map<String , Object> listItem = new HashMap<String , Object>();
            listItem.put("header",images[i]);
            listItem.put("name" , array1[i]);
            listItem.put("desc", array2[i]);
            listItems.add(listItem);

        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.lvi_simple,
                new String[]{"name","header","desc"},new int[]{R.id.tv_lvi_simple_name,R.id.iv_lvi_simple_title,R.id.tv_lvi_simple_desc});

        mLvSimple.setAdapter(simpleAdapter);
        View v = getLayoutInflater().inflate(R.layout.lvi_simple,null);
        mLvSimple.addFooterView(v);


    }

    private void initView() {
        mLvSimple = (ListView) findViewById(R.id.lv_simple);
    }
}
