package com.example.android.quakereport;

import android.content.Context;
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
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView

        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeView.setText(formatter.format(currentEarthquake.getMagnitude()));

        TextView nearView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView locationView = (TextView) listItemView.findViewById(R.id.primary_location);

//        String location = currentEarthquake.getLocation();
//        if(location.contains("Near the")) {
//            String small = location.substring(8, location.length());
//            nearView.setText(R.string.near_the);
//            locationView.setText(small);
//        } else {
//            String[] part = location.split(" of ");
//            nearView.setText(part[0] + " of ");
//            locationView.setText(part[1]);
//        }


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

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


}
