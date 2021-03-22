package Assignment_Reading_Web_Logs;

import java.util.Date;

public class Tester {
    public void testLogEntry(){
        LogEntry logEntry = new LogEntry("1.2.3.4", new Date(), "request", 200, 500);
        System.out.println(logEntry);
    }

    public void testLogAnalyzer(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAll();
    }
}
