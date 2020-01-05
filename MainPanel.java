
import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel { //main panel for the game
	public MainPanel(int unit, Color themeColor) {	
		this.setLayout(new GridLayout(1, 2)); // set up grid layout 2x2
		this.setBackground(themeColor); // set up background color
		this.setBorder(BorderFactory.createEmptyBorder(2*unit,2*unit,2*unit,2*unit));		//set up panel's border
	}
}
