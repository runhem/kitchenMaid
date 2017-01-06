package iristk.app.kitchenMaid;
/*
 * Copyright (c) 2000 David Flanagan.  All rights reserved.
 * This code is from the book Java Examples in a Nutshell, 2nd Edition.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, or to purchase the book (recommended),
 * visit http://www.davidflanagan.com/javaexamples2.
 */

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;

public class AnimateMe extends Frame implements Runnable {
	int x = 300, y= 300, r = 55; // Position and radius of the circle
	
	int grow = 1; // Variable to select if the animation should grow or decrease
	
	int seconds = 0;
	String sec = "";
	String min = "";
	
	Graphics g; 
	
	Color c = Color.blue;
	
	volatile boolean talk = true;
	volatile boolean listen = false;
	volatile boolean timer = false;
	
	Thread animator; // The thread that performs the animation
	
	public AnimateMe(){
		prepareGUI();	
		animator = new Thread(this); // Create a thread
		animator.start(); // Start the thread.
	}
		
	private void prepareGUI(){
		setSize(600, 600);
		centerFrame();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}			
		});
	}

    private void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
}
    
	public void paint(Graphics g) {
	    g.setColor(c);
	    g.fillOval(x - r, y - r, r * 2, r * 2);
	    
	    Font font = new Font("Serif", Font.PLAIN, 50);
	    g.setFont(font);
	    g.drawString(min + ":" + sec, 40, 150); 
	}
	 
	public void animateTalk() {
	  r = r;
	} 
	
	public void animateListen() {
		  if(grow == 0){
			  if(r>55){
				  r=r-1;
			  }else{
				  grow=1;
				  r=r+1;
			  }
		  }else{
			if(r<70){
				r=r+1;
			}else{
				grow=0;
				r=r-1;
			} 
			  
		  }
		  repaint();
	}

	public void setTimer(String time){
		timer = true;
				
		seconds = Integer.parseInt(time);
		sec = Integer.toString(Math.round(seconds % 60));	
		min = Integer.toString(Math.round((seconds/60) % 60));  

		repaint();
	}
	
	public void animateTimer(){
		if (seconds > 0) {  
			seconds--;
			
			sec = Integer.toString(Math.round(seconds % 60));	
			min = Integer.toString(Math.round((seconds/60) % 60));
			
			repaint();
		} else{ 
			timer = false;
		}
	}	
	 
	public void run() {
		int i = 0;
		while(true){
			if(i == 10){
					animateTimer();
					i = 0;
				}
			if(listen) { // Loop until we're asked to stop
				animateListen(); // Update and request redraw
			}
			try {
				i ++;
				Thread.sleep(100);
			} // Wait 100 milliseconds
			catch (InterruptedException e) {
			} // Ignore interruptions
		}
	}
	
	//Returns the timer boolean that returns true if the timer is running and false if the timer is finished
	public boolean timerReady(){
		if(timer){
			return false;
		}else{
			return true;
		}
 	}
	
	public String returnSeconds(){
		return min + "minutes and" + sec + "seconds";
	}
	
	public void setListen(){
		listen = true;
		talk = false;
	}

	public void setTalk(){
		listen = false;
		talk = true;
	}
	
	
}
