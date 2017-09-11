package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<MenuItemBean> menuItemBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        CircleMenuLayout circleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        circleMenuLayout.setAdapter(new CircleMenuAdapter(this, menuItemBeanList));
        circleMenuLayout.setOnItemClickListener(new CircleMenuLayout.OnItemClickListener() {
            @Override
            public void onClick(View itemView, int position) {

            }
        });
    }

    private void initData() {
        for (int i = 0; i < 6; i++) {
            menuItemBeanList.add(new MenuItemBean("afaf", R.mipmap.ic_launcher));
        }
    }
}
