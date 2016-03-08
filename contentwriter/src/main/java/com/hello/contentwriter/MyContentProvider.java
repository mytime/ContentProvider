package com.hello.contentwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * 自定义内容提供者类
 *
 * 0 在Manifest.xml中注册provider
 * 1 创建数据库和数据表
 * 2 复写插入、查询方法
 */
public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    /**
     * AndroidManifest.xml 中注册provider是定义的官方地址
     * android:authorities="com.hello.mycontentprovider"
     * content://  固定的头部
     *
     */
    public static final Uri URI = Uri.parse("content://com.hello.mycontentprovider");


    /**
     * database 定义数据库对象
     */
    SQLiteDatabase database;

    /**
     * mycp.db3: 数据库名称
     * Context.MODE_PRIVATE: 数据库使用法为，只能被当前这个类调用
     * null: 指针工厂
     *
     * @return true: 数据框创建完成
     */
    @Override
    public boolean onCreate() {

        /** 创建/打开数据库 */
        database = getContext().openOrCreateDatabase(
                "mycp.db3",
                Context.MODE_PRIVATE,
                null);

        /** 创建数据表*/
        database.execSQL("create table tab(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)");

        return true;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        /**
         * tab      :   表名
         * _id      :   锁
         * values   :   要插入的内容
         */
        database.insert("tab", "_id", values);

        /**关闭数据库 , 关闭后其他应用无法通过 getContentResolver调用数据 */
//        database.close();

        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        /**
         * @return cursor: 返回一个数据集
         */
        Cursor cursor= database.query("tab",null,null,null,null,null,null);

        return cursor;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }






    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
