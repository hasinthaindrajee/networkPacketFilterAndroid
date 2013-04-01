package org.umit.android.psniffer;

import android.net.TrafficStats;

public class KillProcessThread implements Runnable {

	Process p;
	@Override
	public void run() {
		try{
			p.destroy();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
		
	}

	public KillProcessThread(Process p)
	{
		this.p = p;
	}
}
