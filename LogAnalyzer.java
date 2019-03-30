/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author John Burkert
 * @version April 1st 2019
 * 
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    public LogAnalyzer(String logFileName) {
        
        
        hourCounts = new int[24];
        
        reader = new LogfileReader(logFileName);
        
        
    }
    
    public int numberOfAccesses() {
        
        int total = 0;
        
        for(int hours = 0; hours < hourCounts.length; hours++) {
            
            total = total + hourCounts[hours];
            
        }
        
        return total;
        
        
    }
    
    public int busiestHour() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int quietestHour() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int busiestTwoHour() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int quietestDay() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int busiestDay() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int totalAccessesPerMonth() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int quietestMonth() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int busiestMonth() {
        
     int index = 0;
     
     return index;
        
    }
    
    public int averageAccessesPerMonth() {
        
     int index = 0;
     
     return index;
        
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
