package com.zhisimina.listviewtest.baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhisimina.listviewtest.R;


/**
 * @author fupengpeng
 * @description BaseAdapter
 * @date 2018/3/22 0022 10:50
 */
public class BaseActivity extends AppCompatActivity {

    ListView mLvBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        initData();


    }

    private void initData() {

        BaseAdapter baseAdapter = new BaseAdapter() {
            //  列表子项数量
            @Override
            public int getCount() {
                return 50;
            }

            // 第position处的列表项内容
            @Override
            public Object getItem(int position) {
                return null;
            }

            // 第position处的列表项id
            @Override
            public long getItemId(int position) {
                return position;
            }

            // 第position处的列表项组件
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                convertView = BaseActivity.this.getLayoutInflater().inflate(R.layout.lvi_simple, null);
                ImageView ivLviTitle = convertView.findViewById(R.id.iv_lvi_simple_title);
                TextView tvLviName = convertView.findViewById(R.id.tv_lvi_simple_name);
                TextView tvLviDesc = convertView.findViewById(R.id.tv_lvi_simple_desc);
                ivLviTitle.setImageResource(R.drawable.xian);
                tvLviName.setText("第 " + position + " 个列表项");
                tvLviDesc.setText("第 " + position + " 个列表项 说明");

                return convertView;
            }
        };
        mLvBase.setAdapter(baseAdapter);
        mLvBase.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING){
                    ImageView image = mLvBase.findViewById(R.id.iv_lvi_simple_title);

                }else {

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });


    }

    private void initView() {
        mLvBase = (ListView) findViewById(R.id.lv_base);
    }


    /* --------------------  适配器优化  --------------------*/
    /*
    注意事项：1.在getView()方法中尽量少进行逻辑处理
              2.减少itemView布局的层级
              3.GC（垃圾回收器，暂时不懂），在getView()中创建多个对象后，不用时系统就会调用GC进行垃圾回收。(https://zhuanlan.zhihu.com/magilu/20282779)
              4.加载网络图片，滑动监听中根据滑动状态设置是否加载图片()。
          优化借鉴：https://www.jianshu.com/p/f0408a0f0610
     */
    // 优化一: 每次获取view时进行判断，convertView是否为空，是，则创建视图；否，则使用已经消失的视图(条目view)；
    //         然后设置数据。
    //   缺点：每次都需要重新获取视图中的控件。
    BaseAdapter baseAdapter01 = new BaseAdapter() {
        //  列表子项数量
        @Override
        public int getCount() {
            return 50;
        }

        // 第position处的列表项内容
        @Override
        public Object getItem(int position) {
            return null;
        }

        // 第position处的列表项id
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 第position处的列表项组件
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = BaseActivity.this.getLayoutInflater().inflate(R.layout.lvi_simple, null);
            }
            ImageView ivLviTitle = convertView.findViewById(R.id.iv_lvi_simple_title);
            TextView tvLviName = convertView.findViewById(R.id.tv_lvi_simple_name);
            TextView tvLviDesc = convertView.findViewById(R.id.tv_lvi_simple_desc);
            ivLviTitle.setImageResource(R.drawable.xian);
            tvLviName.setText("第 " + position + " 个列表项");
            tvLviDesc.setText("第 " + position + " 个列表项 说明");

            return convertView;
        }
    };
    // 优化二：使用静态内部类(ViewHolder)将视图中的控件保存起来，每次只需要从ViewHolder中获取就可以，
    //         不再通过findViewById方法去获取。
    BaseAdapter baseAdapter02 = new BaseAdapter() {
        //  列表子项数量
        @Override
        public int getCount() {
            return 50;
        }

        // 第position处的列表项内容
        @Override
        public Object getItem(int position) {
            return null;
        }

        // 第position处的列表项id
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 第position处的列表项组件
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = BaseActivity.this.getLayoutInflater().inflate(R.layout.lvi_simple, null);
                viewHolder.ivLviTitle = convertView.findViewById(R.id.iv_lvi_simple_title);
                viewHolder.tvLviName = convertView.findViewById(R.id.tv_lvi_simple_name);
                viewHolder.tvLviDesc = convertView.findViewById(R.id.tv_lvi_simple_desc);
                // 使用setTag方法将convertView和viewHolder关联起来
                convertView.setTag(viewHolder);
            }else {
                // 当convertView不为空时，使用getTag方法获取到已有的组件
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.ivLviTitle.setImageResource(R.drawable.xian);
            viewHolder.tvLviName.setText("第 " + position + " 个列表项");
            viewHolder.tvLviDesc.setText("第 " + position + " 个列表项 说明");

            return convertView;
        }
    };

    static class ViewHolder {
        ImageView ivLviTitle;
        TextView tvLviName;
        TextView tvLviDesc;
    }


}
