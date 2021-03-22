package Assignment_Website_Visits;

import edu.duke.FileResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry logEntry : records){
            if(!counts.containsKey(logEntry.getIpAddress())){
                counts.put(logEntry.getIpAddress(), 1);
            }else{
                counts.put(logEntry.getIpAddress(), counts.get(logEntry.getIpAddress()) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
        int maxCount = 0;
        for (String count : counts.keySet()){
            if(maxCount < counts.get(count)){
                maxCount = counts.get(count);
            }
        }
        return maxCount;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
        int maxCount = mostNumberVisitsByIP(counts);
        ArrayList<String> ips = new ArrayList<>();
        for (String count : counts.keySet()){
            if(maxCount == counts.get(count)) {
                ips.add(count);
            }
        }
        return ips;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> daysAndIps = new HashMap<>();
        String pattern = "MMM DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (LogEntry logEntry : records){
            if(!daysAndIps.containsKey(simpleDateFormat.format(logEntry.getAccessTime()))){
                ArrayList<String > temp = new ArrayList<>();
                temp.add(logEntry.getIpAddress());
                daysAndIps.put(simpleDateFormat.format(logEntry.getAccessTime()), temp);
            }else{
                ArrayList<String > temp = daysAndIps.get(simpleDateFormat.format(logEntry.getAccessTime()));
                temp.add(logEntry.getIpAddress());
                daysAndIps.put(simpleDateFormat.format(logEntry.getAccessTime()), temp);
            }
        }
        return daysAndIps;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> daysAndIps){
        int maxCount = 0;
        String dayFinal = "";
        for (String day : daysAndIps.keySet()){
            if(daysAndIps.get(day).size() > maxCount){
                maxCount = daysAndIps.get(day).size();
                dayFinal = day;
            }
        }
        return dayFinal;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> daysAndIps, String date){
        ArrayList<String> ips = daysAndIps.get(date);
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry logEntry : records){
            if(ips.contains(logEntry.getIpAddress())){
                if(!counts.containsKey(logEntry.getIpAddress())){
                    counts.put(logEntry.getIpAddress(), 1);
                }else{
                    counts.put(logEntry.getIpAddress(), counts.get(logEntry.getIpAddress())+1);
                }
            }
        }
        return iPsMostVisits(counts);
    }
}
