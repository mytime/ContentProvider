package com.hello.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * 在contentwrite /AndroidManifest.xml 中定义的官方Uri
     */
    Uri URI = Uri.parse("content://com.hello.mycontentprovider");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * getContentResolver(内容拆分器)中的query方法查询
         * URI：指向MyContentProvider.query -> database数据库
         */
        Cursor cursor = getContentResolver().query(URI, null, null, null, null, null);

        /**指针移动到第一行*/
        cursor.moveToFirst();

        /** 根据cursor的数据量来确定循环的次数*/
        for (int i = 0; i < cursor.getCount(); i++) {

            String value = cursor.getString(cursor.getColumnIndex("name"));
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            cursor.moveToNext();

        }
    }
}
