package Assignment_Reading_Web_Logs;

import java.util.ArrayList;
import edu.duke.*;

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
}
