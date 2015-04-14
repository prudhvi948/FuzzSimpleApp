package com.prudhvi.fuzzsimpleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.prudhvi.fuzzsimpleapp.imagehelpers.ImageLoader;
import com.prudhvi.fuzzsimpleapp.models.Data;


public class ImagesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        Bundle extras = null;
        String str = null;
        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            if(extras == null) {
                str = null;
            }
            else {
                str = extras.getString("Data Object");
            }
        }
        else {
            str = (String) savedInstanceState.getSerializable("Data Object");
        }
        Integer i = Integer.parseInt(str);
        Data data = MainActivity.getDataArrayList().get(i);

        ImageView imageView = (ImageView) findViewById(R.id.fullImageView);
        ImageLoader imageLoader = new ImageLoader(App.getContext());
        imageLoader.displayImage(data.getData(), imageView);
    }
}
