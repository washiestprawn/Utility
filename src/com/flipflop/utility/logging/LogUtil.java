package com.flipflop.utility.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogUtil {
	public static void initRootLogger(Logger logger) {
		LogManager.getLogManager().reset();
		
		logger.setLevel(Level.ALL);
		
		try {
//			Handler soch = new StandardOutConsoleHandler();
//			soch.setLevel(Level.ALL);
//			soch.setFormatter(new SimplerFormatter());
//			soch.setFilter(new NoErrorFilter());
//			logger.addHandler(soch);
			
			Handler ch = new ConsoleHandler();
			ch.setLevel(Level.ALL);
			ch.setFormatter(new SimplerFormatter());
			logger.addHandler(ch);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		logger.info("RootLogger registered: "+logger.getName());
	}
	
	public static class NoErrorFilter implements Filter{
		
		@Override
		public boolean isLoggable(LogRecord record) {
			if (record.getLevel() == Level.SEVERE
					|| record.getLevel() == Level.WARNING) {
				return false;
			}
			return true;
		}
		
	}
}
