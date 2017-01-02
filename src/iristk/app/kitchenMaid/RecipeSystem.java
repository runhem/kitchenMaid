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

import iristk.speech.SpeechGrammarContext;
import iristk.speech.Voice.Gender;
import iristk.speech.windows.WindowsRecognizerFactory;
import iristk.speech.windows.WindowsSynthesizer;
import iristk.system.IrisUtils;
import iristk.system.SimpleDialogSystem;
import iristk.util.Language;
import iristk.app.kitchenMaid.RecipeFlow;
import iristk.cfg.SRGSGrammar;
import iristk.flow.FlowModule;
import iristk.situated.SituatedDialogSystem;
import iristk.situated.SystemAgentFlow;

import iristk.app.kitchenMaid.AnimateMe;
import iristk.app.kitchenMaid.InstructionSet;
//import iristk.app.kitchenMaid.RecipeFlow;

public class RecipeSystem {

	public RecipeSystem() throws Exception {
		// Create the system
		SimpleDialogSystem system = new SimpleDialogSystem(this.getClass());
	//	SystemAgentFlow systemAgentFlow = system.addSystemAgent();
		
		// Set the language of the system
		system.setLanguage(Language.ENGLISH_US);
		
		// Uncomment this if you want to turn on logging
		//system.setupLogging(new File("c:/iristk_logging"), true);
		
		// Set up the GUI
		system.setupGUI();
		
		// Add the recognizer to the system
		system.setupRecognizer(new WindowsRecognizerFactory());
		
		// Add a synthesizer to the system		
		system.setupSynthesizer(new WindowsSynthesizer(), Gender.FEMALE);
		
		// Add the flow
		//system.addModule(new FlowModule(new RecipeFlow(instructions, systemAgentFlow)));
	    AnimateMe animation = new AnimateMe();  
	    animation.setVisible(true);
		
		InstructionSet instructions = new InstructionSet(system.getPackageFile("recipe.txt"));
	
		system.addModule(new FlowModule(new RecipeFlow(instructions, animation))); 
		

		// Load a grammar in the recognizer
		system.loadContext("default", new SpeechGrammarContext(new SRGSGrammar(system.getPackageFile("RecipeGrammar.xml"))));
		
		// Start the interaction
		system.sendStartSignal();
	}

	public static void main(String[] args) throws Exception {
		new RecipeSystem();
	}

}
