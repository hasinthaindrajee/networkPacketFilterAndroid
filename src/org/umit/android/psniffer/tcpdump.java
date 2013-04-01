package org.umit.android.psniffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import android.app.Activity;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class tcpdump extends Activity {
/** Called when the activity is first created. */
	Process process;
	TextView tv;
	static String s;
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	
	//tv=(TextView) findViewById(R.id.textView2);
	Process p;
	try 
	{	p = Runtime.getRuntime().exec("su");
		try 
		{	p.waitFor();
			if (p.exitValue() != 255) 
			{
				Log.v("TCPDUMP", "ROOT");
			}
			else 
			{
				Log.v("TCPDUMP", "NOT ROOT");
			}
		} 
		catch (InterruptedException e) 
		{
			Log.v("TCPDUMP", "NOT ROOT");
		}
	}
	
	catch (IOException e) 
	{ 
		e.printStackTrace(); 
	}
		
	Button start = (Button)findViewById(R.id.start);
	start.setOnClickListener(startSniffing);

	Button stop = (Button)findViewById(R.id.stop);
	stop.setOnClickListener(stopSniffing);
	

	
	final Button backButton = (Button) findViewById(R.id.view);

	// profName.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);

	backButton.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Intent i = new Intent(tcpdump.this,
					resultView.class);
			String name = "example";
			i.putExtra("NAME", name);
			startActivityForResult(i, 0);
			resultView.getString(s);
		}
	});
}

private OnClickListener startSniffing = new OnClickListener() 
{
	@Override
	public void onClick(View v)
	{			
		try {
			process = Runtime.getRuntime().exec("tcpdump");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			
			int read;
			char[] buffer = new char[1024];
			StringBuffer output = new StringBuffer();
			try{
			while ((read = reader.read(buffer)) > 0) 
			{
				output.append(buffer, 0, read);
				 s=output.toString();
				//tv.setText(s);
				output = new StringBuffer();
				break;
			}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			throw new RuntimeException(e);
		}
		
			
	}
	
	
	
};

private OnClickListener stopSniffing = new OnClickListener() {
	public void onClick(View v){
		KillProcessThread t = new KillProcessThread(process);
		t.run();
	}
};




}