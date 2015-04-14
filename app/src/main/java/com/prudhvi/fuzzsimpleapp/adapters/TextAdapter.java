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
import com.prudhvi.fuzzsimpleapp.models.Data;

import java.util.List;

/**
 * Created by prudhvi on 4/11/2015.
 * This is the adapter for the ListView inside the 2nd TabbedView names as 'Text'
 */
public class TextAdapter extends ArrayAdapter<Data> {

    public TextAdapter(Context context, List<Data> objects)
    {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.cell_text, parent, false);
        }

        ListCell listCell = new ListCell();
        listCell.idTextView = (TextView) convertView.findViewById(R.id.textViewIdText);
        listCell.typeTextView = (TextView) convertView.findViewById(R.id.textViewTypeText);
        listCell.dateTextView = (TextView) convertView.findViewById(R.id.textViewDateText);
        listCell.dataTextView = (TextView) convertView.findViewById(R.id.textViewDataText);

        Data data = getItem(position);
        listCell.idTextView.setText(data.getId());
        listCell.typeTextView.setText(data.getType());
        listCell.dateTextView.setText(data.getDate());
        listCell.dataTextView.setText(data.getData());

        return convertView;
    }

    private static class ListCell {
        TextView idTextView;
        TextView typeTextView;
        TextView dateTextView;
        TextView dataTextView;
    }
}
