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
     * Create an object to analyze hourly, daily, monthly, and yearly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[32];
        monthCounts = new int[13];
        yearCounts = new int[366];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    /**
     * Create an object to analyze hourly, daily, monthly, and yearly web accesses 
     * by file name.
     */
    public LogAnalyzer(String logFileName) {
        
        
        hourCounts = new int[24];
        dayCounts = new int[32];
        monthCounts = new int[13];
        yearCounts = new int[366];
        
        reader = new LogfileReader(logFileName);
        
        
    }
    
    /**
     * Shows the amount of accesses in the log file.
     */
    
    public int numberOfAccesses() {
        
        int total = 0;
        
        for(int hours = 0; hours < hourCounts.length; hours++) {
            
            total = total + hourCounts[hours];
            
        }
        
        return total;
        
        
    }
    
    /**
     * Shows the busiest hour count in the log file.
     */
    
    public int busiestHour() {
        
     int busyHours = 0;
     
     for(int hours = 0; hours < hourCounts.length; hours++) {
         
         if(hourCounts[hours] >= hourCounts[busyHours]) {
             
             busyHours = hours;
             
            }
         
        }
     
     return busyHours;
        
    }
    
    /**
     * Shows the quietest hour count in the log file.
     */
    
    public int quietestHour() {
        
     int quietHours = 0;
     
     for(int hours = 0; hours < hourCounts.length; hours++) {
         
         if(hourCounts[hours] <= hourCounts[quietHours]) {
             
             quietHours = hours;
             
            }
         
        }
     
     return quietHours;
        
    }
    
    /**
     * Shows the busiest two-hour period
     * in the log file.
     */
    
    public int busiestTwoHour() {
        
     int busyTwoHour = 0;
     
     
     
     for(int hours = 0; hours < hourCounts.length; hours++) {
         
         if(busyTwoHour > 12) {

             busyTwoHour -= hours;
             
            }
            
            else if(busyTwoHour < 12) {

             busyTwoHour = hours;   
                
            }
         
        }
     
     return busyTwoHour;
        
    }
    
    /**
     * Shows the quietest day count in the log file.
     */
    
    public int quietestDay() {
        
        
     int quietDays = 0;
     
     for(int days = 0; days < dayCounts.length; days++) {
         
         if(dayCounts[days] <= dayCounts[quietDays]) {
             
             quietDays = days;
             
            }
         
        }
     
     return quietDays;
        
        
    }
    
    /**
     * Shows the busiest day count in the log file.
     */
    
    public int busiestDay() {
        
     int busyDays = 0;
     
     for(int days = 0; days < dayCounts.length; days++) {
         
         if(dayCounts[days] >= dayCounts[busyDays]) {
             
             busyDays = days;
             
            }
         
        }
     
     return busyDays;
        
    }
    
    /**
     * Shows the total amount of accesses per month
     * in the log file.
     */
    
    public int totalAccessesPerMonth() {
        
     int total = 0;
        
        for(int months = 0; months < monthCounts.length; months++) {
            
            total = total + monthCounts[months];
            
        }
        
        return total;
        
    }
    
    /**
     * Shows the quietest month count in the log file.
     */
    
    public int quietestMonth() {
        
     int quietMonths = 0;
     
     for(int months = 0; months < monthCounts.length; months++) {
         
         if(monthCounts[months] <= monthCounts[quietMonths]) {
             
             quietMonths = months;
             
            }
         
        }
     
     return quietMonths;
        
    }
    
    /**
     * Shows the busiest month count in the log file.
     */
    
    public int busiestMonth() {
        
     int busyMonths = 0;
     
     for(int months = 0; months < monthCounts.length; months++) {
         
         if(monthCounts[months] >= monthCounts[busyMonths]) {
             
             busyMonths = months;
             
            }
         
        }
     
     return busyMonths;
        
    }
    
    /**
     * Shows the average amount of accesses per month
     * in the log file.
     */
    
    public int averageAccessesPerMonth() {
        
     int total = 0;
     
     int average = 0;
        
        for(int months = 5; months < monthCounts.length; months++) {
            
            total = total + monthCounts[months];
            
            average = total / monthCounts[months];
            
        }
        
        return total;
        
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
