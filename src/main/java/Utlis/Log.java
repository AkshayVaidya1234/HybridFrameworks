package Utlis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	public static final Logger log = LogManager.getLogger();
	
	public static void info(String message) {
		log.info(message);
	}
	public static void warn(String message) {
		log.warn(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}
	
	
}
