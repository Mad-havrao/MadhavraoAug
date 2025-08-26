package Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

import Reports.ExtentTestManager;

public class Log {
	
	private static final Logger Log = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {

        Log.info(message);
        extentLog(message);

    }

    public static String infoMessage(String message){
        Log.info(message);
        extentLog(message);
        return message;
    }

    public static void warn(String message) {
        Log.warn(message);
        extentLog(message);
        // cucumberLog(message);
    }

    public static void error(String message) {

        Log.error(message);
        extentLog(message);
    }

    private static void extentLog(String message) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.INFO, message);
        }

    }

}
