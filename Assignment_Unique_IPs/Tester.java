package Assignment_Unique_IPs;

import java.text.ParseException;
import java.util.ArrayList;
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

    public void testUniqueIP(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println(logAnalyzer.countUniqueIPs());
    }

    public void testPrintAllHigherThanNum(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAllHigherThanNum(100);
    }

    public void testUniqueIPVisitsOnDay() throws ParseException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog-short_log");
        ArrayList<String> ips = logAnalyzer.uniqueIPVisitsOnDay("Sep 30");
        for (String ip : ips){
            System.out.println(ip);
        }
    }

    public void testCountUniqueIPsInRange(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println(logAnalyzer.countUniqueIPsInRange(300,399));
    }
}
