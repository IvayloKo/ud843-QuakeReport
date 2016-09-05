package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smn on 9/5/16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextVIew = (TextView) listItemView.findViewById(R.id.tvMagnitude);
        magnitudeTextVIew.setText(currentEarthquake.getMagnitude());

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.tvPlace);
        placeTextView.setText(currentEarthquake.getPlace());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.tvDate);
        dateTextView.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
