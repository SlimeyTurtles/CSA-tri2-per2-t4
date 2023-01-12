package com.nighthawk.spring_portfolio.mvc.calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** Calendar API
 * Calendar Endpoint: /api/calendar/isLeapYear/2022, Returns: {"year":2020,"isLeapYear":false}
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarApiController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions on bad JSON
     *  @throws JsonProcessingException
     *  @throws JsonMappingException
     */
    @GetMapping("/isLeapYear/{year}")
    public ResponseEntity<JsonNode> getIsLeapYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj = new Year();
      year_obj.setYear(year);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json = mapper.readTree(year_obj.isLeapYearToString()); // this requires exception handling

      return ResponseEntity.ok(json);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    // add other methods
    @GetMapping("/firstDayOfYear/{year}")
    public ResponseEntity<JsonNode> getFirstDayOfYear(@PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj1 = new Year();
      year_obj1.setYear(year);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper1 = new ObjectMapper(); 
      JsonNode json1 = mapper1.readTree(year_obj1.firstDayOfYearToString()); // this requires exception handling

      return ResponseEntity.ok(json1);  // JSON response, see ExceptionHandlerAdvice for throws
    }

    @GetMapping("/dayOfWeek/{month}/{day}/{year}")
    public ResponseEntity<JsonNode> getDayOfWeek(@PathVariable int month, @PathVariable int day, @PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj2 = new Year(month, day);
      year_obj2.setYear(year);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper2 = new ObjectMapper(); 
      JsonNode json2 = mapper2.readTree(year_obj2.dayOfWeekToString()); // this requires exception handling

      return ResponseEntity.ok(json2);  // JSON response, see ExceptionHandlerAdvice for throws
    }
    

    @GetMapping("/dayOfYear/{month}/{day}/{year}")
    public ResponseEntity<JsonNode> getDayOfYear(@PathVariable int month, @PathVariable int day, @PathVariable int year) throws JsonMappingException, JsonProcessingException {
      // Backend Year Object
      Year year_obj3 = new Year(month, day);
      year_obj3.setYear(year);  // evaluates Leap Year

      // Turn Year Object into JSON
      ObjectMapper mapper3 = new ObjectMapper(); 
      JsonNode json3 = mapper3.readTree(year_obj3.dayOfYearToString()); // this requires exception handling

      return ResponseEntity.ok(json3);  // JSON response, see ExceptionHandlerAdvice for throws
    }

//     @GetMapping("/numberOfLeapYears/{year1}/{year2}")
//     public ResponseEntity<JsonNode> getNumberOfLeapYears(@PathVariable int month, @PathVariable int day, @PathVariable int year) throws JsonMappingException, JsonProcessingException {
//       // Backend Year Object
//       Year year_obj4 = new Years(year1, year2);
//       year_obj4.setYear(year);  // evaluates Leap Year

//       // Turn Year Object into JSON
//       ObjectMapper mapper4 = new ObjectMapper(); 
//       JsonNode json4 = mapper4.readTree(year_obj4.numberOfLeapYearsToString()); // this requires exception handling

//       return ResponseEntity.ok(json4);  // JSON response, see ExceptionHandlerAdvice for throws
//     }
}
