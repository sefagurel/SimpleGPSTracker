package com.sefagurel.simplegpstracker;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.sefagurel.simplegps.ISimpleGps;
import com.sefagurel.simplegps.SimpleGPS;

public class ReceiverActivity extends Activity implements ISimpleGps {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SimpleGPS.minDistanceChangeForUpdates = 10;
		SimpleGPS.minTimeForUpdates = 0;
		SimpleGPS.isGPSEnabled = false;
		SimpleGPS.isNetworkEnabled = true;

		SimpleGPS.tracker().start();

		Receiver1 receiver1 = new Receiver1();
		Receiver2 receiver2 = new Receiver2();

	}

	@Override
	public void locationChanged(LocationManager locationManager, Location location) {
		Log.i("ReceiverActivity", location.getLatitude() + "," + location.getLongitude());
	}

	@Override
	protected void onResume() {
		super.onResume();
		SimpleGPS.tracker().attach(this);

	}

	@Override
	protected void onPause() {
		super.onPause();
		SimpleGPS.tracker().remove(this);
	}
}
