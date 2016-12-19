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

//Question class med id, question, category, answers, correct som attribut nu. 
//Vi kan ändra dessa sen till något annat 
//kolla hur det kan matchas med textfilen eller om det bestäms i Question nedan?
public class Instruction {

	private  String id;
	private String question;
	// private String[] answers = new String[4];
	// private int correct;
	private String action;
	private String ingredient;
	private String measure;
	private String container;
	
	private String returnstring;
	
	
	//Getting different parts of the intruction lines and storing them in the right variables
	public Instruction(String id, String[] cols) {
		
		//Frågeid
		this.id = id;
		
		// Fetches action - there is always an action in the instructions
		action = cols[0].trim();
		
		//skapa lista som heter order, endast till för svarsalternativen 
		//List<Integer> order = Arrays.asList(new Integer[]{0, 1, 2, 3});
		
		//Blanda svarens ordning - kommer vi ej behöva ?
//		RandomList.shuffle(order);
//		
//		answers[order.get(0)] = cols[0].trim();
//		answers[order.get(1)] = cols[0].trim();
//		answers[order.get(2)] = cols[0].trim();
//		answers[order.get(3)] = cols[0].trim();
//		
		//Vilket som är rätt svar - kommer vi ej behöva? 
		//correct = order.get(0);
		
		//If there are measurement, ingredient or container on line we create these
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
	
	//Returns instruction on different formats depending on what it contains *** CHANGE NAME TO getFullInstruction() ***  
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
	
	//Kan vi änvända fast för någonting annat sen, typ 'repeat' eller någon följdfråga
//	public Object getOptions() {
//		return answers[0] + ", " + answers[1] + ", " + answers[2] + ", or " + answers[3];
//	}
	
	
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


	//Användas för confirmation 'ready'/'not ready'
//	public String getCorrectAnswer() {
//		return answers[correct];
//	}

	//Feedback för att vi ska gå vidare typ? 
//	public boolean isCorrect(Object answer) {
//		return answer != null && answer.toString().equals("answer" + correct);
//	}

	//För att veta vilken fråga vi är på - eller vilket steg för oss sen
	public String getId() {
		return id;
	}
	
	
}
