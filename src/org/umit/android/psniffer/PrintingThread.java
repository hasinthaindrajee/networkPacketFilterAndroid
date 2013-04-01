package org.umit.android.psniffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

import android.net.TrafficStats;
import android.util.Log;
import android.widget.TextView;

public class PrintingThread  {
	TextView tv;
	BufferedReader reader;
	public static long TotalTxBytes,TotalRxBytes,TotalRxPackets,TotalTxPackets;

	
	
	public PrintingThread(BufferedReader reader)
	{
		this.reader = reader;
	}
	
	public void capture(){
		TotalRxBytes=TrafficStats.getTotalRxBytes();
		TotalTxBytes=TrafficStats.getTotalTxBytes();
		TotalRxPackets=TrafficStats.getTotalRxPackets();
		TotalTxPackets=TrafficStats.getTotalTxPackets();
		
		
	}

}
