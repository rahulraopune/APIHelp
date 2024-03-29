package rahulapps.apihelp.Sensor;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SensorProximityAPI extends Activity implements SensorEventListener
{
	SensorManager sm;
	TextView tvfar,tvnear,tvsensorvalue;
	Sensor sensorobj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_proximity);
		
		sm = (SensorManager)getSystemService(SENSOR_SERVICE);
		
		tvfar = (TextView)findViewById(R.id.Sensor_Proximity_Far);
		tvnear = (TextView)findViewById(R.id.Sensor_Proximity_Near);
		tvsensorvalue = (TextView)findViewById(R.id.tv_proximity_value);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event)
	{
		// TODO Auto-generated method stub
		if(event.sensor.getType()==Sensor.TYPE_PROXIMITY)
		{
			float dist = event.values[0];
			tvsensorvalue.setText("VALUE: "+String.valueOf(dist));
			
			if(dist==0)
			{
				tvfar.setVisibility(View.INVISIBLE);
				tvnear.setVisibility(View.VISIBLE);
				
			}
			else
			{
				tvfar.setVisibility(View.VISIBLE);
				tvnear.setVisibility(View.INVISIBLE);
				
			}
			
		}
		
	}
	
	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		sm.unregisterListener(this);
		super.onPause();
	}
	
	
}
