package com.yufeng.day030_fragmentscreanadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        TextView textView = (TextView) findViewById(R.id.content_text);
        textView.setText(getIntent().getStringExtra("content"));

    }
}
