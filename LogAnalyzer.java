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
    private int[] dayCounts;
    private int[] monthCounts;
    private int[] yearCounts;
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
        dayCounts = new int[32];
        monthCounts = new int[13];
        yearCounts = new int[12];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    public LogAnalyzer(String logFileName) {
        
        
        hourCounts = new int[24];
        dayCounts = new int[32];
        monthCounts = new int[13];
        yearCounts = new int[12];
        
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
        
     int busyHours = 0;
     
     for(int hours = 18; hours < hourCounts.length; hours++) {
         
         if(hourCounts[hours] >= hourCounts[busyHours]) {
             
             busyHours = hours;
             
            }
         
        }
     
     return busyHours;
        
    }
    
    public int quietestHour() {
        
     int quietHours = 0;
     
     for(int hours = 9; hours < hourCounts.length; hours++) {
         
         if(hourCounts[hours] <= hourCounts[quietHours]) {
             
             quietHours = hours;
             
            }
         
        }
     
     return quietHours;
        
    }
    
    public int busiestTwoHour() {
        
     int busyFirstHour = 0;
     
     int busySecondHour = 0;
     
     for(int hours = 0; hours < hourCounts.length; hours++) {
         
         if(busyFirstHour < hours) {
             
             busySecondHour += busyFirstHour;
             
             busyFirstHour = hours;
             
            }
            
            else if(busySecondHour < hours) {
             
             busyFirstHour += busySecondHour;
                
             busySecondHour = hours;   
                
            }
         
        }
     
     return busyFirstHour;
        
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
     * Analyze the daily access data from the log file.
     */
    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }
    }
    
    /**
     * Analyze the monthly access data from the log file.
     */
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month]++;
        }
    }
    
    /**
     * Analyze the yearly access data from the log file.
     */
    public void analyzeYearlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int year = entry.getYear();
            yearCounts[year]++;
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
     * Print the daily counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     */
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    
    /**
     * Print the monthly counts.
     * These should have been set with a prior
     * call to analyzeMonthlyData.
     */
    public void printMonthlyCounts()
    {
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
        }
    }
    
    /**
     * Print the yearly counts.
     * These should have been set with a prior
     * call to analyzeYearlyData.
     */
    public void printYearlyCounts()
    {
        System.out.println("Year: Count");
        for(int year = 0; year < yearCounts.length; year++) {
            System.out.println(year + ": " + yearCounts[year]);
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
