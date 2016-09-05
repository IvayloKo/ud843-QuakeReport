package com.example.android.quakereport;

/**
 * Created by smn on 9/5/16.
 */
public class Earthquake {

    private String mMagnitude;

    private String mLocation;

    private long mTimeInMilliseconds;

    public Earthquake(String magnitude, String location, long timeInMilliseconds) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(String mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public void setTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "Magnitude='" + mMagnitude + '\'' +
                ", Location='" + mLocation + '\'' +
                ", TimeInMilliseconds='" + mTimeInMilliseconds + '\'' +
                '}';
    }
}
