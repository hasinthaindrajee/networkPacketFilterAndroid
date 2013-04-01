package org.umit.android.psniffer;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class resultView  extends Activity{
	private static String results;
	 List<PieDetailsItem> piedata = new ArrayList<PieDetailsItem>(0);
	 List<PieDetailsItem> piedata2 = new ArrayList<PieDetailsItem>(0);
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {
		
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		PrintingThread t= new PrintingThread(null);
		t.capture();
		int value1=(int)(PrintingThread.TotalRxBytes*100/(PrintingThread.TotalRxBytes+PrintingThread.TotalTxBytes));
		int value2=(int) ((t.TotalTxBytes*100/(t.TotalRxBytes+t.TotalTxBytes)));
		
		 PieDetailsItem item;
		  int maxCount = 0;
		  int itemCount = 0;
		  int items[] = { 0, value1,value2, 0, 0 };
		  int colors[] = { -6777216, -16776961, -16711681, -12303292, -7829368 };
		  String itemslabel[] = { " vauesr ur 100", " vauesr ur 200",
		    " vauesr ur 300", " vauesr ur 400", " vauesr ur 500" };
		  for (int i = 0; i < items.length; i++) {
		   itemCount = items[i];
		   item = new PieDetailsItem();
		   item.count = itemCount;
		   item.label = itemslabel[i];
		   item.color = colors[i];
		   piedata.add(item);
		   maxCount = maxCount + itemCount;
		  }
		  int size = 300;
		  int BgColor = 0xffa11b1;
		  Bitmap mBaggroundImage = Bitmap.createBitmap(size, size,
		    Bitmap.Config.ARGB_8888);
		  View_PieChart piechart = new View_PieChart(this);
		  piechart.setLayoutParams(new LayoutParams(size, size));
		  piechart.setGeometry(size, size, 2, 2, 2, 2, 2130837504);
		  piechart.setSkinparams(BgColor);
		  piechart.setData(piedata, maxCount);
		  piechart.invalidate();
		  piechart.draw(new Canvas(mBaggroundImage));
		  piechart = null;
		  ImageView mImageView = new ImageView(this);
		  mImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
		    LayoutParams.WRAP_CONTENT));
		  mImageView.setBackgroundColor(BgColor);
		  mImageView.setImageBitmap(mBaggroundImage);
		  LinearLayout finalLayout = (LinearLayout) findViewById(R.id.pie_container);
		  finalLayout.addView(mImageView);
		  //////////////////////////////////////////////////////////////////
		  int value3=(int)(PrintingThread.TotalRxPackets*100/(PrintingThread.TotalRxPackets+PrintingThread.TotalTxPackets));
			int value4=(int) ((t.TotalTxPackets*100/(t.TotalRxPackets+t.TotalTxPackets)));
			System.out.println("heeeeeeeeeeeeee"+value1);
			System.out.println(value2);
			
			 PieDetailsItem item2;
			  int maxCount2 = 0;
			  int itemCount2 = 0;
			  int items2[] = { value3, 0,0, value4, 0 };
			  int colors2[] = { -6777216, -16776961, -16711681, -12303292, -7829368 };
			  String itemslabel2[] = { " vauesr ur 100", " vauesr ur 200",
			    " vauesr ur 300", " vauesr ur 400", " vauesr ur 500" };
			  for (int i = 0; i < items2.length; i++) {
			   itemCount2 = items2[i];
			   item2 = new PieDetailsItem();
			   item2.count = itemCount2;
			   item2.label = itemslabel2[i];
			   item2.color = colors2[i];
			   piedata2.add(item2);
			   maxCount2 = maxCount2 + itemCount2;
			  }
			  int size2 = 300;
			  int BgColor2 = 0xffa11b1;
			  Bitmap mBaggroundImage2 = Bitmap.createBitmap(size2, size2,
			    Bitmap.Config.ARGB_8888);
			  View_PieChart piechart2 = new View_PieChart(this);
			  piechart2.setLayoutParams(new LayoutParams(size2, size2));
			  piechart2.setGeometry(size2, size2, 2, 2, 2, 2, 2130837504);
			  piechart2.setSkinparams(BgColor2);
			  piechart2.setData(piedata2, maxCount2);
			  piechart2.invalidate();
			  piechart2.draw(new Canvas(mBaggroundImage2));
			  piechart2 = null;
			  ImageView mImageView2 = new ImageView(this);
			  mImageView2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
			    LayoutParams.WRAP_CONTENT));
			  mImageView2.setBackgroundColor(BgColor2);
			  mImageView2.setImageBitmap(mBaggroundImage2);
			  LinearLayout finalLayout2 = (LinearLayout) findViewById(R.id.pie_container2);
			  finalLayout2.addView(mImageView2);
			  
		  
		  //////////////////////////////////////////////////////////////////
		  
			  TextView titlea= (TextView)findViewById(R.id.title4);
				titlea.setText( "Pie chart 1: Total Bytes captured ");
				TextView titleb= (TextView)findViewById(R.id.title3);
				titleb.setText("Pie chart 1: Total Packets captured ");
		
		TextView title= (TextView)findViewById(R.id.title);
		title.setText("Summery of the Session (shown in Pie chart 1) ");
		TextView view1= (TextView)findViewById(R.id.capture1);
		view1.setText("TotalRxBytes caputured :"+t.TotalRxBytes);
		
		TextView view2= (TextView)findViewById(R.id.capture2);
		view2.setText("TotalTxBytes caputured :"+t.TotalTxBytes);
		
		
		TextView title2= (TextView)findViewById(R.id.title2);
		title2.setText("Summery of the Session (shown in Pie chart 2) ");
		
		TextView view3= (TextView)findViewById(R.id.capture3);
		view3.setText("Total bytes captured :"+t.TotalRxPackets);
		
		TextView view4= (TextView)findViewById(R.id.capture4);
		view4.setText("Total packets recieved :"+t.TotalTxPackets);
		TextView view= (TextView)findViewById(R.id.textView3);
		view.setText(results);
		System.out.println("The result isssss "+results);

	}
	
	public static void getString(String string){
	results= string;	
	}


}
