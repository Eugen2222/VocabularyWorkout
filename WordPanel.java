import java.awt.*;
import javax.swing.*;


public class WordPanel extends JPanel {
	private JLabel balanceL = new JLabel(); //create a label for player's balance
	private JLabel statusL = new JLabel(); //create a label for player's status
	private JLabel countL = new JLabel();
	private Font wordF;	//create a font for the text
	
	public WordPanel(int unit, Color themeColor) {	
		this.setBorder(BorderFactory.createEmptyBorder(unit,2*unit,unit,unit));
		this.setLayout(new GridLayout(3,1));	//set up layout 3x1 
		this.add(balanceL);		//add the balance label in the panel
		this.add(statusL);	
		this.add(countL);//add the status label in the panel
		this.setBackground(themeColor);	//set the background color of the panel
		this.setVisible(true);	//set the panel to be visible
		wordF = new Font(Font.SANS_SERIF,Font.BOLD,32);	//set up the font style
		balanceL.setFont(wordF);	//set up the font of balance label
		statusL.setFont(wordF);
		countL.setFont(new Font(Font.SERIF,Font.CENTER_BASELINE,16));//set up the font of status label
	}
	//a setter to set text and its color 
	public void setWord(String text) {
		balanceL.setText(String.format("<html><font color='rgb(70,70,70)'>%s</font></html>",text));
	}
	//a setter to set text and its color 	
	public void setAnswer(String text) {
		statusL.setText(String.format("<html><font color='rgb(70,70,70)'>%s</font></html>",text));
	}
	//a setter to set text and its color 	
	public void setCount(String text) {
		countL.setText(String.format("<html><font color='rgb(70,70,70)'>%s</font></html>",text));
	}

}
