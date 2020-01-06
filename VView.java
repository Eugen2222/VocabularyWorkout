//Name: WEI-TING, LIN
//Matric: 2434295l

import java.awt.Color;
import javax.swing.*;

public class VView extends JFrame {
	private MainPanel innerPanel; //Declare a inner panel.
	private WordPanel wordPanel; //Declare a status panel and empty panel.
	private ButtonPanel	buttonPanel; //Declare a button panel.
	
	private int unit = 10; //Declare a border unit
	private int size = 420;	//Declare a size value
	private int width = (int)(1.4*size); //Declare a width using size
	private int height = size; //Declare a height using size
	private Color themeColor = new Color(250, 250 , 250);  //Declare a theme color
	private Color subColor = new Color(50, 230, 210);  //Declare a sub theme color
	
	//Constructor to set up the game window and panels.
	public VView() { 
		this.setTitle("Vocabulary Learning"); //set window title
		this.setSize(width,height); // set window size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //enable user to close the program
		layoutComponents(); // put all the panels together inside the window
		restart();
	}

	private void layoutComponents() { // combine all the panels together
		innerPanel = new MainPanel(unit, themeColor); 
		// create a inner panel with border using unit and colors defined above	
		wordPanel = new WordPanel(unit, themeColor);
		// create a status panel using color defined above
		buttonPanel = new ButtonPanel(unit, themeColor, subColor);
		// create a button panel with border using unit and colors defined above		
		innerPanel.add(wordPanel); //add a status Panel in inner panel
		innerPanel.add(buttonPanel); //add a button Panel in inner panel
		this.add(innerPanel); //add the inner panel to the game window
		//set view to visible 
		this.setVisible(true);	
	}
	
	public void showAnswer(String v) { // update all panels
		wordPanel.setAnswer(v);
		//set player win text from model data
		getAnswer().setEnabled(false); //disable spin button
	}
	
	public void pickWord(String v) { //reset all panels
		//set cards from model data
		wordPanel.setWord(v);
		//set player's point from model data
		wordPanel.setAnswer("");
 
		//set player status from model data
		//set player's win text from model data
	}
	
	//a getter from button panel to the controller
	public JButton getPick() {
		return buttonPanel.getPick();
	}
	
	//a getter from button panel to the controller
	public JButton getAnswer() {
		return buttonPanel.getAnswer();
	}
	
	public JButton getNote() {
		return buttonPanel.getNote();
	}
	
	public JButton getExamNote() {
		return buttonPanel.getExamNote();
	}
	public JButton getRestart() {
		return buttonPanel.getRestart();
	}
	
	public void setCount(String text) {
		wordPanel.setCount(text);
	}
	
	
	public void restart() {
		setCount("");
		pickWord("Welcome!!!");
		getPick().setEnabled(true);
		getAnswer().setEnabled(false);
		getNote().setEnabled(false);
		getExamNote().setEnabled(false);

	}
}



