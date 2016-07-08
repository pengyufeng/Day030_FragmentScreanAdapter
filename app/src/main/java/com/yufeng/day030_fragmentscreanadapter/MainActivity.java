package com.yufeng.day030_fragmentscreanadapter;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Fragment> fragmentList;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private List<String> list;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screan_adapter);

        listView = (ListView) findViewById(R.id.title_list);
        list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            list.add("第 "+i+" 元素");

        }

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        fragmentList = new ArrayList<Fragment>();

        manager = getSupportFragmentManager();


        bundle = new Bundle();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    MyFragment fragment = new MyFragment();

                    bundle.putString("title", list.get(position));
                    fragment.setArguments(bundle);
                    manager.beginTransaction().replace(R.id.main_framelayout,fragment).commit();
                }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                    intent.putExtra("content",list.get(position));
                    startActivity(intent);
                }
            }
        });
    }
}
