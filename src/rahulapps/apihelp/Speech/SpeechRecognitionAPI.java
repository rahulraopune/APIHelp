package rahulapps.apihelp.Speech;

import java.util.ArrayList;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SpeechRecognitionAPI extends Activity implements OnClickListener
{
	ListView lv;
	Button bspeak;
	ArrayAdapter<String> arrayadapter;
	
	public static final int check = 1111;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);
		
		lv = (ListView)findViewById(R.id.speech_listview);
		bspeak = (Button)findViewById(R.id.speech_button);
		
	    bspeak.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Up !....Dude");
		startActivityForResult(intent,check);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		if(requestCode==check && resultCode == RESULT_OK)
		{
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results);
			lv.setAdapter(arrayadapter);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
}
