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
	 
	int seconds = 10;
	String sec = Integer.toString(seconds);
	
	Color c = Color.blue;
	
	volatile boolean talk = true;
	volatile boolean listen = false;
	volatile boolean timer = true;
	
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
//	    Font font = new Font("Serif", Font.PLAIN, 50);
//	    g.setFont(font);
//	    g.drawString(sec, 40, 150); 
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

	public void animateTimer(){
		if (seconds > 0) {  
			seconds--;
			sec = Integer.toString(seconds);
			repaint();
		} else{ 
			timer = false;
		}
	}	
	
	public void run() {
		while(true){
//			if(timer){
//				animateTimer();			
//				try {
//					Thread.sleep(1000);
//				} // Wait 100 milliseconds
//				catch (InterruptedException e) {
//				} // Ignore interruptions			
//			}
			while (talk) { // Loop until we're asked to stop
				try {
					Thread.sleep(70);
				} // Wait 100 milliseconds
				catch (InterruptedException e) {
				} // Ignore interruptions
			}
			while (listen) { // Loop until we're asked to stop
				animateListen(); // Update and request redraw
				try {
					Thread.sleep(50);
				} // Wait 100 milliseconds
				catch (InterruptedException e) {
				} // Ignore interruptions
		    }
		}
	}	
	
//Returns the timeFinished variable that will be true if the timer is finished and otherwise false
//	public boolean timerRunning(){
//		return timer;
// 	}
	
//	public String getSeconds(){
//		return sec;
//	}
	
	public void setListen(){
		listen = true;
		talk = false;
	}

	public void setTalk(){
		listen = false;
		talk = true;
	}
	
	
}
