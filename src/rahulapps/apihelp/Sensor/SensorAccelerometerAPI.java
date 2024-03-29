package rahulapps.apihelp.Sensor;


import rahulapps.apihelp.R;
import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SensorAccelerometerAPI extends Activity implements SensorEventListener
{
	
	View v;
	SensorManager sm;
	public long lastupdate;
	public boolean color=false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_api);
		
		v = (View)findViewById(R.id.ABC);
		v.setBackgroundColor(Color.CYAN);
		
		lastupdate = System.currentTimeMillis();
		
		sm = (SensorManager)getSystemService(SENSOR_SERVICE);
		
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
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
		{
			float[] values = event.values;
			float x = values[0];
			float y = values[1];
			float z = values[2];
			
			float accelerationsquareroot = (x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
			
			long actualtime = event.timestamp;
			
			if(accelerationsquareroot >= 2)
			{
				if(actualtime-lastupdate < 200)
				{
					return;
				}
				lastupdate=actualtime;
				
				Toast t = Toast.makeText(getApplicationContext(), "Device was Shaked",Toast.LENGTH_SHORT-3);
				t.show();
				
				if(color)
				{
					v.setBackgroundColor(Color.CYAN);
				}
				else
				{
					
					v.setBackgroundColor(Color.TRANSPARENT);
				}
				color = !color;
				
			}
		}
		
	}

	
	  @Override
	  protected void onResume()
	  {
	    super.onResume();
	    // register this class as a listener for the orientation and
	    // accelerometer sensors
	    sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause()
	  {
	    // unregister listener
	    super.onPause();
	    sm.unregisterListener(this);
	  }


}
