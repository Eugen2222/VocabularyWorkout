//Name: WEI-TING, LIN
//Matric: 2434295l

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


public class ButtonPanel  extends JPanel{
	private JButton pickButton = new JButton();	//create a spin button
	private JButton answerButton = new JButton();	//create a new game button
	private JButton noteButton = new JButton();	
	private JButton examNoteButton = new JButton();	
	private JButton restartButton = new JButton();
	private Font buttonF;	//declare a font 
	
	public ButtonPanel(int unit,Color themeColor, Color subColor) {
		//set up the layout of the panel grid 2*1
		this.setLayout(new GridLayout(5,1,(int)(1.5*unit),(int)(1.5*unit)));
		//set up the border of the panel
		this.setBorder(BorderFactory.createEmptyBorder(4*unit,5*unit,4*unit,5*unit));
		//set up the background color of the panel
		this.setBackground(themeColor);
		//set up the font style
		this.buttonF = new Font(Font.SERIF,Font.ROMAN_BASELINE,14);
		//set up the background of the button 
		pickButton.setBackground(subColor);
		//disable focus effect
		pickButton.setFocusable(false);
		//set up the font
		pickButton.setFont(buttonF);
		//set up text
		pickButton.setText("Pick");		
		
		//set up the background of the button 
		answerButton.setBackground(subColor);
		//disable focus effect
		answerButton.setFocusable(false);
		//set up the font
		answerButton.setFont(buttonF);
		//set up text
		answerButton.setText("Answer");
		//add spin button to panel
		
		noteButton.setBackground(subColor);
		//disable focus effect
		noteButton.setFocusable(false);
		//set up the font
		noteButton.setFont(buttonF);
		//set up text
		noteButton.setText("Note");
		
		examNoteButton.setBackground(subColor);
		//disable focus effect
		examNoteButton.setFocusable(false);
		//set up the font
		examNoteButton.setFont(buttonF);
		//set up text
		examNoteButton.setText("Exam Note");
		
		restartButton.setBackground(subColor);
		//disable focus effect
		restartButton.setFocusable(false);
		//set up the font
		restartButton.setFont(buttonF);
		//set up text
		restartButton.setText("Restart");
		
		this.add(pickButton);
		//add new game button to panel
		this.add(answerButton);
		//add new game button to panel
		this.add(noteButton);
		
		this.add(examNoteButton);
		this.add(restartButton);
	}
	
	//a getter pass the button to view
	public JButton getPick() {
		return pickButton;
	}
	//a getter pass the button to controller
	public JButton getAnswer() {
		return answerButton;
	}
	
	public JButton getNote() {
		return noteButton;
	}
	
	public JButton getExamNote() {
		return examNoteButton;
	}
	
	public JButton getRestart() {
		return restartButton;
	}
	
}
