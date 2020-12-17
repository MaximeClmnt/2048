package main;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		
		Object[] colours = {"Left", "Up", "Down", "Right"};
		int n =4;
		n = JOptionPane.showOptionDialog(null,
		    "Which colour do you like?",
		    "Choose a colour",
		    JOptionPane.DEFAULT_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    colours,
		    colours[0]);

		System.out.println(n);

	}

}
