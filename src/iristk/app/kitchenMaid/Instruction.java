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

import java.util.Arrays;
import java.util.List;

import iristk.util.RandomList;

//Instruction class
public class Instruction {

	//Declaration of variables
	private  String id;
	private String question;
	private String action;
	private String ingredient;
	private String measure;
	private String container;
	
	private String returnstring;
	
	
	//Getting different parts of the intruction lines and storing them in the right variables
	public Instruction(String id, String[] cols) {
	
		//Instruction id, to know which one we're at 
		this.id = id;
		
		// Fetching action - there is always an action in the instructions
		action = cols[0].trim();
		
		//If there are measurement, ingredient or container on line we create them here
		if (cols.length > 1) {
			measure = cols[1].trim();
		}
		if (cols.length > 2) {
			ingredient = cols[2].trim();
		}
		if (cols.length > 3) {
			container = cols[3].trim();
		}
	}
	
	//Returns instruction on different formats depending on what it contains
	public String getFullInstruction() {
		returnstring = action;
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
	
	public String getMeasurement(){
		return measure;
	}

	public String getIngredient(){
		return ingredient;
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
