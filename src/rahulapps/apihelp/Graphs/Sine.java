package rahulapps.apihelp.Graphs;

import android.app.Activity;
import android.os.Bundle;

public class Sine extends Activity
{
	
	SineView sine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sine = new SineView(this);
		setContentView(sine);
	}
}
