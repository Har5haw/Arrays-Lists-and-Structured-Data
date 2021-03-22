package Assignment_Unique_IPs;

import edu.duke.FileResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        records = new ArrayList<>();
    }
    public void readFile(String fileName){
        FileResource fileResource = new FileResource(fileName);
        for (String line : fileResource.lines()){
            LogEntry logEntry = WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }
    public void printAll(){
        for (LogEntry logEntry : records){
            System.out.println(logEntry);
        }
    }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIps = new ArrayList<>();
        for (LogEntry logEntry : records){
            if(!uniqueIps.contains(logEntry.getIpAddress())){
                uniqueIps.add(logEntry.getIpAddress());
            }
        }
        return uniqueIps.size();
    }

    public void printAllHigherThanNum(int num){
        for (LogEntry logEntry : records){
            if (logEntry.getStatusCode() > num){
                System.out.println(logEntry);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String date) throws ParseException {
        String pattern = "MMM DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date givenDate =  simpleDateFormat.parse(date);
        ArrayList<String> ips = new ArrayList<>();
        for (LogEntry logEntry : records){
            if(givenDate.equals(logEntry.getAccessTime())){
                ips.add(logEntry.getIpAddress());
            }
        }
        return ips;
    }

    public int countUniqueIPsInRange(int high, int low){
        ArrayList<LogEntry> uniqueIps = new ArrayList<>();
        for (LogEntry logEntry : records){
            if(!uniqueIps.contains(logEntry.getIpAddress())){
                if(logEntry.getStatusCode() <= high && logEntry.getStatusCode() >= low){
                    uniqueIps.add(logEntry);
                }
            }
        }
        return uniqueIps.size();
    }


}
