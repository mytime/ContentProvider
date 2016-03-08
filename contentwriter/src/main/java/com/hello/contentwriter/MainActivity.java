package com.hello.contentwriter;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();



    }

    private void initObject() {

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsert:
                write();
                break;
        }
    }

    /**
     * 写入数据表
     */
    private void write() {

        /**实例化一个内容容器*/
        ContentValues values = new ContentValues();
        values.put("name","Java");
//        values.put("name","Swift");
//        values.put("name","Python");
//        values.put("name","C#");

        /**
         * 写入到库
         * 使用getContentResolver（内容分解器）的insert方法执行插入
         * MyContentProvider.URI ：自定义的官方Uri
         * values: 插入的内容
         */
        getContentResolver().insert(MyContentProvider.URI,values);
    }
}











