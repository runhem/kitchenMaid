/*******************************************************************************
 * Copyright (c) 2014 Gabriel Skantze.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gabriel Skantze - initial API and implementation
 ******************************************************************************/
package iristk.app.kitchenMaid;


import java.util.Timer; 
import java.util.TimerTask;

import java.util.Arrays;
import java.util.List;

import iristk.util.RandomList;

//Instruction class
public class Instruction {
 
	//Declaration of variables
	private String id;
	private String action;
	private String ingredient;
	private String measure;
	private String container;
	private Timer timer; 
	private String time;
	private String amount;
	private boolean timeFinished; 
	private String sec; 
	
	private String returnstring;
	
	//Getting different parts of the intruction lines and storing them in the right variables
	public Instruction(String id, String[] cols) {
	
		//Instruction id, to know which one we're at 
		this.id = id;
		
		// Fetching action - there is always an action in the instructions
		action = cols[0].trim();
		
		//If there are measurement, ingredient or container on line we create them here
		if (cols.length > 1) {
			amount = cols[1].trim();
		}
		if (cols.length > 2) {	
			measure = cols[2].trim();
		}
		if (cols.length > 3) {
			ingredient = cols[3].trim();
		}
		if (cols.length > 4) {
			container = cols[4].trim();
		}
	}
	
	//Returns instruction on different formats depending on what it contains
	public String getFullInstruction() {
		returnstring = action;
		if(amount != null){
			returnstring = returnstring + " " + amount;
		}
		if(measure != null){
			returnstring = returnstring + " " + measure;
		}
		if(ingredient != null){
			returnstring = returnstring + " of " + ingredient;
		}
		if(container != null){
			returnstring = returnstring  + " to the " + container;
		}
		
		return  returnstring;
	}
	

	//Checks if there is an ingredient for the step, in that case returns the ingredient
		//Otherwise it returns a string saying "no ingredient" that can be used as error handling in the flow
		public String getIngredient(){
			if(ingredient != null){
				return ingredient;
			}
			else{
				return "no ingredient"; 
			}
		}
		
		
		//Returns the amount from the recipe if there is an amount
		public String getAmount(){
			if(amount != null){
				return amount;
			}
			else{
				return "no amount";
			}
		}
		
		//Checks if there is a measurement for the step, in that case returns the measurement
		//Otherwise it returns a string saying "no measurement" that can be used as error handling in the flow
		public String getMeasurement(){
			if(measure !=null){
				return measure;
			}
			else{
				return "no measurement";
			}
		}
		
		//Checks if there is a container for the step, in that case returns the container
		//Otherwise it returns a string saying "no container" that can be used as error handling in the flow
		public String getContainer(){
			if(container != null){
				return container;
			}
			else{
				return "no container";
			}
		}
		
		//Returns true if the measurement is in minutes because that means that we should start a timer
		public boolean getTimer(){
				if (measure.equals("seconds")){
					return true;
				}
				else{
					return false;
				}
		}
		
		//Running timer
		public void setTimer(){
			timeFinished = false;
			 timer =new Timer();
			 timer.schedule(new TimerTask(){
				public Integer seconds = Integer.parseInt(amount); 
				 public void run() { 
						if (seconds > 0) { 
							System.out.println(seconds); 
							seconds--; 
							sec = Integer.toString(seconds);
							} 
						else { 
							System.out.println("Time's up!");  
							timer.cancel(); 
							timeFinished = true;
							} 
						}
				 
			 }, 0, 1000); 
		}
		
		//Returns the timeFinished variable that will be true if the timer is finished and otherwise false
		public boolean isTimerReady(){
			return timeFinished;
		}
		
		public String getSeconds(){
			return sec;
		}
		
	// *** Look into how we should change this *** 
//	public String getGrammar() {
//		StringBuilder grammar = new StringBuilder();
//		//"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
//		grammar.append("<grammar xml:lang=\"en-US\" version=\"1.0\" root=\"root\" xmlns=\"http://www.w3.org/2001/06/grammar\" tag-format=\"semantics/1.0\">");
//		grammar.append("<rule id=\"root\" scope=\"public\"><one-of>");
//		for (int i = 0; i < 4; i++) {
//			grammar.append("<item>" + answers[i] + "<tag>out.answer=\"answer" + i + "\"</tag></item>");
//		}
//		grammar.append("</one-of></rule></grammar>");	
//		return grammar.toString();
//	}

	//Returns the id
	public String getId() {
		return id;
	}
	
}
