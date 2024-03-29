package rahulapps.apihelp.Settings;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CommentAPI extends Activity implements OnClickListener
{
	Button bDone;
	EditText etName,etSubject,etBody;
	String sName,sSubject,sBody;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment);
		
		bDone = (Button)findViewById(R.id.BUTTON_COMMENT_DONE);
		etBody = (EditText)findViewById(R.id.EDITTEXT_COMMENT_BODY);
		etName = (EditText)findViewById(R.id.EDITTEXT_COMMENT_NAME);
		etSubject = (EditText)findViewById(R.id.EDITTEXT_COMMENT_SUBJECT);
		
		bDone.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.BUTTON_COMMENT_DONE:
			
			sName = etName.getText().toString();
			sSubject = etSubject.getText().toString();
			sBody = etBody.getText().toString();
			
			
			String body = "Hey Wassap I am"+sName+","+"\n"+sBody+"\n"+"Bye";
			
			
			Uri emailuri = Uri.fromParts("mailto","rahulraopune@gmail.com",null);
			Intent intentemail = new Intent(Intent.ACTION_SENDTO,emailuri);
			intentemail.putExtra(Intent.EXTRA_SUBJECT,sSubject);
			intentemail.putExtra(Intent.EXTRA_TEXT, body);
			intentemail.putExtra(Intent.EXTRA_TITLE,sName);
			startActivity(intentemail);
			
			
			break;
		}
	}
	
	
}
