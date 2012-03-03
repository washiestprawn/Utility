package com.flipflop.utility.logging;

import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimplerFormatter extends Formatter{

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	@Override
	public String format(LogRecord record) {
		StringBuilder message = new StringBuilder(record.getLevel().getName());
		message.append("(").append(record.getSequenceNumber()).append(") ");
		message.append(record.getSourceClassName()).append(":").append(record.getSourceMethodName()).append(" - ");
		message.append(record.getMessage());
		
		message.append(System.getProperty("line.separator"));
		return message.toString();
	}

}
