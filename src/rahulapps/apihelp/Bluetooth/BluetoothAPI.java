package rahulapps.apihelp.Bluetooth;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class BluetoothAPI extends Activity implements OnCheckedChangeListener
{
	Switch sw;
	BluetoothAdapter bluetoothAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth_api);
		
		sw = (Switch)findViewById(R.id.BluetoothAPI_Switch);
		sw.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onCheckedChanged(CompoundButton switchbutton, boolean arg1)
	{
		// TODO Auto-generated method stub
		switch (switchbutton.getId())
		{
		case R.id.BluetoothAPI_Switch:
			
			if(sw.isChecked())
			{
				bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
				
				if(bluetoothAdapter==null)
				{
					Toast t = Toast.makeText(getApplicationContext(),"Bluetooth Service not Enabled",Toast.LENGTH_LONG);
					t.show();
				}
				
				if(bluetoothAdapter.isEnabled())
				{
					Toast t = Toast.makeText(getApplicationContext(),"Bluetooth Service already Running",Toast.LENGTH_LONG);
					t.show();
				}	
				if(!bluetoothAdapter.isEnabled())
				{ 
					
					Intent discoverableintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					discoverableintent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,300);
					startActivity(discoverableintent);
				}
				
					
			}
				
			
			else
			{
				bluetoothAdapter.disable();
			
				Toast t = Toast.makeText(getApplicationContext(),"Bluetooth OFF",Toast.LENGTH_LONG);
				t.show();
			}
			
			break;
		}
		
	}
	

}
