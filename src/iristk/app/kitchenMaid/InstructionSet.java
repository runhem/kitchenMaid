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
	
	private int n = 0;
	
	//Här stoppar vi in questionfile som vi sedan läser av
	public InstructionSet(InputStream questionFile) throws IOException {
		try {	
			
			//br här är vår fil-isch
			BufferedReader br = new BufferedReader(new InputStreamReader(questionFile));
			
			//Här läser vi textfilen rad för rad
			String line = br.readLine();
			
			int qn = 0;
			int ln = 0;
			
			
			//Så länge det finns en rad att läsa - kollar så raden är giltig 
			while ((line = br.readLine()) != null) {
				ln++;
				if (!line.matches("[A-Za-z0-9,\\.;\\?'\\- ]*")) {
					System.err.println("Illegal line " + ln + ": " + line);
					continue;
				}
				
				//Separera för varje ; och lägg i lista
				String[] cols = line.split(";");
				
				//Här kan vi bestämma hur många rader den ska läsa 
				if (cols.length < 1) {
					logger.warn("Not enough columns in line " + ln + ": " + line);
					continue;
				} 
				
				//Skapa frågeobjekt - och formatera raden beroende på vad det är för delar
				//I detta fall har vi ju fråga, svar, kategori osv. Detta kan vi ändra sen
				Instruction q = new Instruction("q" + qn++, cols);
				add(q);
			}
			logger.info(qn + " questions read");
		} catch (IOException e) {
			throw new IOException("Problem reading questions: " + e.getMessage());
		}
	}
	
	
	public InstructionSet(File file) throws IOException  {
		this(new FileInputStream(file));
	}
	
	
	// Gets the next intruction *** CHANGE TO Instruction next() *** 
	public Instruction next() {
		Instruction q = get(n);
		n++;
		if (n >= size()) {
			n = 0;
		}
		return q;
	}
	
}
