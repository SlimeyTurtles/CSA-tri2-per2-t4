package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private int month;
   private int day;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int dayOfWeek;
   private int dayOfYear;
   // private int numberOfLeapYears;


   // zero argument constructor
   public Year() {}

   // cool argument constructor
   public Year(int month, int day) {
      this.month = month;
      this.day = day;
   }

   /* year month and date getter/setters */
   public int getYear() {
      return year;
   }

   
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
      this.setDayOfWeek(month, day, year);
      this.setDayOfYear(month, day, year);
   }

   

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }
   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }
   


   /* firstDayOfYear getter/setters */
   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }
   public void setFirstDayOfYear(int year) {  // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }
   /* firstDayOfYearToString formatted to be mapped to JSON */
   public String firstDayOfYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"firstDayOfYear\": "  +this.firstDayOfYear+ " }" );
   }


   
   public int getDayOfWeek(int month, int day, int year) {
      return APCalendar.dayOfWeek(month, day, year);
   }
   public void setDayOfWeek(int month, int day, int year) {  // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(month, day, year);
   }
   /* firstDayOfYearToString formatted to be mapped to JSON */
   public String dayOfWeekToString(){
      return ( "{ \"dayOfWeek\": "  +this.dayOfWeek+ " }" );
   }

   public int getDayOfYear(int month, int day, int year) {
      return APCalendar.dayOfYear(month, day, year);
   }
   public void setDayOfYear(int month, int day, int year) {  // this is private to avoid tampering
      this.dayOfYear = APCalendar.dayOfYear(month, day, year);
   }
   /* firstDayOfYearToString formatted to be mapped to JSON */
   public String dayOfYearToString(){
      return ( "{ \"dayOfYear\": "  +this.dayOfYear+ " }" );
   }
   

   // public int getNumberOfLeapYears(int year1, int year2) {
   //    return APCalendar.numberOfLeapYears(year1, year2);
   // }
   // public void setNumberOfLeapYears(int year1, int year2) {  // this is private to avoid tampering
   //    this.numberOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
   // }
   // /* firstDayOfYearToString formatted to be mapped to JSON */
   // public String numberOfLeapYearsToString(){
   //    return ( "{ \"numberOfLeapYears\": "  +this.numberOfLeapYears+ " }" );
   // }

   /* standard toString placeholder until class is extended */
   // public String toString() { 
   //    return isLeapYearToString(); 
   // }

   public static void main(String[] args) {
      Year year = new Year();

      year.setYear(2022);

      System.out.println(year);
   }
}
