package rahulapps.apihelp.Wifi;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;

import rahulapps.apihelp.R;

public class WifiAPI extends Activity implements OnCheckedChangeListener
{
	Switch swWifi;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_api);
		swWifi = (Switch)findViewById(R.id.WIFI_SWITCH);
		
		
		
		swWifi.setOnCheckedChangeListener(this);
		
		
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
	{
		
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.WIFI_SWITCH)
		{
			WifiManager wifiManager = (WifiManager)this.getSystemService(WIFI_SERVICE);
			
			if (!wifiManager.isWifiEnabled())
			{
				wifiManager.setWifiEnabled(true);
			} 
			
			else if (wifiManager.isWifiEnabled()) 
			{
				wifiManager.setWifiEnabled(false);
			}
						
		}
	}
}
