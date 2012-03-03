package com.flipflop.utility.logging;

import java.util.logging.ConsoleHandler;

public class StandardOutConsoleHandler extends ConsoleHandler {
	public StandardOutConsoleHandler() {
		super();
		super.setOutputStream(System.out);
	}
}
