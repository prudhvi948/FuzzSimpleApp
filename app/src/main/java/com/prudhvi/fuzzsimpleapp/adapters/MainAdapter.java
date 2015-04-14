package com.prudhvi.fuzzsimpleapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prudhvi.fuzzsimpleapp.R;
import com.prudhvi.fuzzsimpleapp.imagehelpers.ImageLoader;
import com.prudhvi.fuzzsimpleapp.models.Data;

import java.util.List;

/**
 * Created by prudhvi on 4/6/2015.
 * This is the common adapter for ListViews inside both the TabbedViews 'All' and 'Images'
 */
public class MainAdapter extends ArrayAdapter<Data> {
    private ImageLoader imageLoader;
    private String s;

    public MainAdapter(Context context, List<Data> objects, String s)
    {
        super(context, 0, objects);
        imageLoader = new ImageLoader(context.getApplicationContext());
        this.s = s;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.cell_main, parent, false);
        }

        ListCell listCell = new ListCell();


        Data data = getItem(position);
        if(s.equals("all")) {
            listCell.idTextView = (TextView) convertView.findViewById(R.id.textViewIdMain);
            listCell.typeTextView = (TextView) convertView.findViewById(R.id.textViewTypeMain);
            listCell.dateTextView = (TextView) convertView.findViewById(R.id.textViewDateMain);
            listCell.dataTextView = (TextView) convertView.findViewById(R.id.textViewDataMain);
            listCell.imageView = (ImageView) convertView.findViewById(R.id.imageViewMain);

            listCell.idTextView.setText(data.getId());
            listCell.typeTextView.setText(data.getType());
            listCell.dateTextView.setText(data.getDate());
            listCell.dataTextView.setText(data.getData());
            imageLoader.displayImage(data.getData(), listCell.imageView);
        }
        else {
            listCell.imageView = (ImageView) convertView.findViewById(R.id.imageViewMain);
            imageLoader.displayImage(data.getData(), listCell.imageView);
        }

        return convertView;
    }

    private static class ListCell {
        ImageView imageView;
        TextView idTextView;
        TextView typeTextView;
        TextView dateTextView;
        TextView dataTextView;
    }
}
