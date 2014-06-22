package rahulapps.apihelp.Graphs;

import android.app.Activity;
import android.os.Bundle;

public class Tan extends Activity{
	
	TanView TanwaveView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TanwaveView = new TanView(this);
		setContentView(TanwaveView);
	}
}
