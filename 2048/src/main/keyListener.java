package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener{
	static int n;

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==37) n=0;
		if (e.getKeyCode()==38) n=1;
		if (e.getKeyCode()==39) n=3;
		if (e.getKeyCode()==40) n=2;
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
