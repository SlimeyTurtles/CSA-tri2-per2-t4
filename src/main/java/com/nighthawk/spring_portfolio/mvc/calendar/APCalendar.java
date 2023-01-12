package com.nighthawk.spring_portfolio.mvc.calendar;

// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if(year%4 == 0){
            if (year%100 == 0){
                if (year%400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
               return true;
            }
        }
        else{
          return false;

        }
        }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    public static int firstDayOfYear(int year) {
        

        return dayOfWeek(1,1,year);
        }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    public static int dayOfWeek(int month, int day, int year) {
        if (month > 2){
            month = month-2;
        }
        else{
            month = month +10;
            year = year-1;
        }
        int d = year % 100; 
        int c = year/100;
        int f = day + (13*month-1)/5 + d + (d/4) +(c/4)-2*c;
        int g=0;
        if (g>f){
            while (g>f){
                g =g -7;
            }
            f = Math.abs(g-f);
            return f;
        }
        else{
            f = f % 7;
            return f;
        }
    }

    public static String converter (int month, int day, int year){
        switch(dayOfWeek(month, day, year)){
            case 0:
                return dayOfWeek(month, day, year) + ", Sunday";
            case 1:
                return dayOfWeek(month, day, year) + ", Monday";
            case 2:
                return dayOfWeek(month, day, year) + ", Tuesday";
            case 3:
                return dayOfWeek(month, day, year) + ", Wednesday";
            case 4:
                return dayOfWeek(month, day, year) + ", Thursday";
            case 5:
                return dayOfWeek(month, day, year) + ", Friday";
            case 6:
                return dayOfWeek(month, day, year) + ", Saturday";
            default:
                return "N/A";
        }
        
    }
    

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
         // to be implemented in part (a)
         int counter = 0;
         while(year1 <= year2){
            if(isLeapYear(year1)){
                counter = counter + 1;
                year1 = year1 + 1;
            }
            else{
                year1 = year1 + 1; 
            }
         }

        return counter;
        }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfYear(int month, int day, int year) { 
        // to be implemented in part (b)
        int dayCounter = 0;
        while (month > 0){
            switch(month - 1){
                case 0:
                    dayCounter += 0;
                    break;
                case 1: 
                    dayCounter += 31;
                    break;
                case 2: 
                    if (isLeapYear(year)){
                        dayCounter += 29;
                    }
                    else{
                        dayCounter += 28;
                    }
                    break;
                case 3:
                    dayCounter += 31;
                    break;
                case 4:
                    dayCounter += 30;
                    break;
                case 5:
                    dayCounter += 31;
                    break;
                case 6:
                    dayCounter += 30;
                    break;
                case 7:
                    dayCounter += 31;
                    break;
                case 8:
                    dayCounter += 31;
                    break;
                case 9:
                    dayCounter += 30;
                    break;
                case 10:
                    dayCounter += 31;
                    break;
                case 11:
                    dayCounter += 30;
                    break;
                case 12:
                    dayCounter += 31;
                    break;
            }
            month -= 1;                
        }
        return dayCounter + day;
        }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2024));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(3, 1, 2016));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(1900));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
        System.out.println("dayOfWeek: " + APCalendar.converter(3, 17, 1992));
    }

}
