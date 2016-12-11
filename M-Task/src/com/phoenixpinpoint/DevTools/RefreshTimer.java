/*********************************************
 * M-Task Version 1.2.3
 * Build:
 * 	Major: 6272016
 *  Minor: 162801
 * 
 * Created by phoenixpinpoint
 * 

 * 
 * Class: RefreshTimer
 * Version: 62720161628
 * 
 * 
 * Support:
 * *********************************************/
package com.phoenixpinpoint.DevTools;

import java.util.TimerTask;

class RefreshTimer extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		MTask.window.refreshTable();
	}
}

