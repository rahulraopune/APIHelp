package rahulapps.apihelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MenuList extends Activity implements OnItemClickListener
{
	ListView lv;
	ArrayAdapter<String> arrayadapter;
	
	String sMenu[]={"Bluetooth",
					"Wifi",
					"Sensor",
					"Splash Activity",
					"List Activity",
					"Speech Recognition",
					"Drawing Graphs",
					"Notifications",
					"File IO",
					"Email",
					"Camera"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_menu);
		
		lv=(ListView)findViewById(R.id.Common_ListView);
		
		arrayadapter = new ArrayAdapter<String>(MenuList.this,android.R.layout.simple_list_item_1,sMenu);
		lv.setAdapter(arrayadapter);
		
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
	{
		// TODO Auto-generated method stub
		switch(position)
		{
		case 0:ActivityStarter("rahulapps.apihelp.Bluetooth.BluetoothMenu");break;
		case 1:ActivityStarter("rahulapps.apihelp.Wifi.WifiMenu");break;
		case 2:ActivityStarter("rahulapps.apihelp.Sensor.SensorMenu");break;
		case 3:ActivityStarter("rahulapps.apihelp.SplashActivity.SplashMenu");break;
		case 4:ActivityStarter("rahulapps.apihelp.Menus.MenuActivityMenu");break;
		case 5:ActivityStarter("rahulapps.apihelp.Speech.SpeechRecognitionMenu");break;
		case 6:ActivityStarter("rahulapps.apihelp.Graphs.GraphMenu");break;
		case 7:ActivityStarter("rahulapps.apihelp.Notifications.NotificationMenu");break;
		case 8:ActivityStarter("rahulapps.apihelp.FileIO.FileIOMenu");break;
		case 9:ActivityStarter("rahulapps.apihelp.Email.EmailMenu");break;
		case 10:ActivityStarter("rahulapps.apihelp.Camera.CameraMenu");break;
		}
	}
	
	public void ActivityStarter(String sActivity)
	{
		Intent intent = new Intent(sActivity);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate( R.menu.common_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		
		case R.id.ABOUT:
			Intent intentAbout = new Intent("rahulapps.apihelp.Settings.AboutAPI");
			startActivity(intentAbout);
			break;
			
		case R.id.COMMENT:
			Intent intentComment = new Intent("rahulapps.apihelp.Settings.CommentAPI");
			startActivity(intentComment);
			break;
			
		case R.id.EXIT:
			finish();
			break;
		}
		return false;
	}
	
	
	
	
}
