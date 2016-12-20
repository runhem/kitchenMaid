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
	
	//H�r stoppar vi in questionfile som vi sedan l�ser av
	public InstructionSet(InputStream questionFile) throws IOException {
		try {	
			
			//br h�r �r v�r fil-isch
			BufferedReader br = new BufferedReader(new InputStreamReader(questionFile));
			
			//H�r l�ser vi textfilen rad f�r rad
			String line = br.readLine();
			
			int qn = 0;
			int ln = 0;
			
			
			//S� l�nge det finns en rad att l�sa - kollar s� raden �r giltig 
			while ((line = br.readLine()) != null) {
				ln++;
				if (!line.matches("[A-Za-z0-9,\\.;\\?'\\- ]*")) {
					System.err.println("Illegal line " + ln + ": " + line);
					continue;
				}
				
				//Separera f�r varje ; och l�gg i lista
				String[] cols = line.split(";");
				
				//H�r kan vi best�mma hur m�nga rader den ska l�sa 
				if (cols.length < 1) {
					logger.warn("Not enough columns in line " + ln + ": " + line);
					continue;
				} 
				
				//Skapa fr�geobjekt - och formatera raden beroende p� vad det �r f�r delar
				//I detta fall har vi ju fr�ga, svar, kategori osv. Detta kan vi �ndra sen
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
