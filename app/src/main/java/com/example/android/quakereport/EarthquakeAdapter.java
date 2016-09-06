package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by smn on 9/5/16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeView.setText(formatter.format(currentEarthquake.getMagnitude()));

        // Primary and offset location
         String originalLocation = currentEarthquake.getLocation();
         String primaryLocation;
         String locationOffset;

         if (originalLocation.contains(LOCATION_SEPARATOR)) {
         String[] parts = originalLocation.split(LOCATION_SEPARATOR);
         locationOffset = parts[0] + LOCATION_SEPARATOR;
         primaryLocation = parts[1];
         } else {
         locationOffset = getContext().getString(R.string.near_the);
         primaryLocation = originalLocation;
         }

         TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
         primaryLocationView.setText(primaryLocation);

         TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
         locationOffsetView.setText(locationOffset);

        // Date and time
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {

        int magnitudeColour = (int) magnitude;
        switch (magnitudeColour) {
            case 0:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 1:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColour = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }

        return magnitudeColour;

    }


}
