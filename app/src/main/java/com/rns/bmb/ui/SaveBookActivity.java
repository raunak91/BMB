package com.rns.bmb.ui;

import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.rns.bmb.R;
import com.rns.bmb.web.MyPostThread;

import java.util.HashMap;


public class SaveBookActivity extends Activity {
    EditText editBook;
    EditText editAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_book);

        this.editAuthor = (EditText) findViewById(R.id.edit_author);
        this.editBook = (EditText) findViewById(R.id.edit_book);
    }

    public void onSaveBook(View view) {
        String author = this.editAuthor.getText().toString();
        String book = this.editBook.getText().toString();
        String device_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        new MyPostThread(new HashMap<String,String>(), "http://192.168.0.104:8080/BookMyBook/user/addBook?BOOK_NAME=" + book +
                "&DEVICE_ID=" + device_id + "&BOOK_AUTHOR=" + author ).start();

        finish();
    }
}
