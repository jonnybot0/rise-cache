// Copyright 2010 - May 2014 Rise Vision Incorporated.
// Use of this software is governed by the GPLv3 license
// (reproduced in the LICENSE file).

package com.risevision.risecache.jobs;

import java.util.Timer;
import java.util.TimerTask;

import com.risevision.risecache.Globals;
import com.risevision.risecache.cache.FileUtils;

public class CheckExpiredJob {

	static class OnTimerTask extends TimerTask {

		@Override
		public void run() {
			FileUtils.deleteExpired();
		}

	}

	private static Timer timer;

	public static void start() {
		timer = new Timer();
		
		timer.schedule(new OnTimerTask(), 1000, Globals.CHECK_EXPIRED_FREQUENCY_MS);
	}

}

