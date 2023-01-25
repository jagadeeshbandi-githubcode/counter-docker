package com.example.counterdocker.controller;


import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/*
 * This controller manages counters
 * Four API end points are provided
 * /all - To return all counters
 * /increment - To increment counter value
 * /get - To get counter value for a given counter name
 * /create - To create new counter
 */
@RestController
public class CounterController {

	public Map<String, Integer> countersMap = new HashMap<>();
	
	 /**
     * This method to create new counter
     * @return String
     */
    @GetMapping("/create/{counterName}")
    public String create(@PathVariable String counterName) {
    	if(countersMap.containsKey(counterName)) {
    		return "Counter already exists";
    	}
    	countersMap.put(counterName , 1);
    	return countersMap.get(counterName).toString();
    }
    
    /** 
     * This method return all counters
     * @return Map<String,Integer> . 
     */
    @GetMapping("/all")
    public Map<String, Integer> getCounter() {
        return countersMap;
    }

    /** 
     * This method is used to increment counter value
     * @return Integer
     */
    @GetMapping("/increment/{counterName}")
    public Integer increment(@PathVariable String counterName) {
    	Integer val = countersMap.get(counterName);
    	val++;
    	countersMap.put(counterName , val);
    	return countersMap.get(counterName);
    }
   
    /** 
     * This method is to get counter value for a given counter name
     * @return Integer
     */
    @GetMapping("/get/{counterName}")
    public Integer getValue(@PathVariable String counterName) {
    	return countersMap.get(counterName);
    }
    
   
}
