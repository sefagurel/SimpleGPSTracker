package com.sefagurel.simplegpstracker;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.sefagurel.simplegps.ISimpleGps;
import com.sefagurel.simplegps.SimpleGPS;

/**
 * Created by sefagurel on 24.07.2015.
 */
public class Receiver1 implements ISimpleGps {

	public Receiver1() {

		SimpleGPS.tracker().attach(this);
	}

	@Override
	public void locationChanged(LocationManager locationManager, Location location) {
		Log.i("Receiver1", location.getLatitude() + "," + location.getLongitude());
	}
}
