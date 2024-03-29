package rahulapps.apihelp.Graphs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class SineView extends View
{
	Paint red;
	Paint blue;

	public SineView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		red = new Paint();
		red.setColor(Color.RED);
		red.setStrokeWidth(3);
		
		blue = new Paint();
		blue.setColor(Color.BLUE);
		blue.setStrokeWidth(5);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		
		super.onDraw(canvas);
		//canvas
		canvas.drawLine(canvas.getWidth()/2-200, canvas.getHeight()/2+50, canvas.getWidth(), canvas.getHeight()/2+50, red);//xaxis
		canvas.drawLine(canvas.getWidth()/2-150, canvas.getHeight()/2-800, canvas.getWidth()/2-150, canvas.getHeight()/2+100,red);//yaxis
		
		for(int i=0;i<=720;i++)//curve
		{
			int x=i+(canvas.getWidth()/2-150);
			int y=(int) ((canvas.getHeight()/2+50)+((float)Math.sin(Math.toRadians(2*i)))*100);
			canvas.drawPoint(x, y,blue);
		}
		
	}
			
		
}
