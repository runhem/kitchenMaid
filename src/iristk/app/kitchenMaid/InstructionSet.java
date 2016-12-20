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

import iristk.system.IrisUtils;
import iristk.util.RandomList;

import java.io.*;
import java.util.*;

import org.slf4j.Logger;

public class InstructionSet extends ArrayList<Instruction> {
	
	private static Logger logger = IrisUtils.getLogger(InstructionSet.class);
	
	private int n = 0; //counter to see where we are
	
	//Creating a set of instructions
	public InstructionSet(InputStream questionFile) throws IOException {
		try {	
			BufferedReader br = new BufferedReader(new InputStreamReader(questionFile));
			//Reading line of text file
			String line = br.readLine();
			
			int instructionNumber = 0;
			int lineNumber = 0;
			
			//As long as line is not equal to null (there is a line)
			while ((line = br.readLine()) != null) {
				lineNumber++;
				if (!line.matches("[A-Za-z0-9,\\.;\\?'\\- ]*")) {
					System.err.println("Illegal line " + lineNumber + ": " + line);
					continue;
				}
				
				//Separate by ';'
				String[] cols = line.split(";");
				
				//Sets 1 item as default for a line, if smaller than that it gives a warning
				if (cols.length < 1) {
					logger.warn("Not enough columns in line " + lineNumber + ": " + line);
					continue;
				} 
				//Creates instruction and adds it
				Instruction i = new Instruction("i" + instructionNumber++, cols);
				add(i);
			}
			logger.info(instructionNumber + " instructions read");
		} catch (IOException e) {
			throw new IOException("Problem reading instruction: " + e.getMessage());
		}
	}
	
	public InstructionSet(File file) throws IOException  {
		this(new FileInputStream(file));
	}
	
	// Gets the next instruction 
	public Instruction next() {	
		Instruction i = get(n);
		n++;
		return i;
	}
	
	//Returns true if we are finished with the recipe, and false otherwise
	//if counter is bigger than size/amount of rows in text file it's the end of the recipe
	public boolean endOfRecipe(){
		if (n >= size()) {
			return true;
		}
		else{
			return false;
			}
		}
	

	
}
