import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VController implements ActionListener{
	private VModel modelObject;	//declare a model
	private VView viewObject;	//declare a view
	
	public VController(String Path) {
		modelObject = new VModel(Path);	//assign model 
		//create a view which gets model and controller
		viewObject = new VView(); 
		viewObject.getPick().addActionListener(this);
		viewObject.getAnswer().addActionListener(this);
		viewObject.getNote().addActionListener(this);
		viewObject.getExamNote().addActionListener(this);
		viewObject.getRestart().addActionListener(this);
	}
	
	//action performs 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.getPick()) { //if spin button is clicked
			modelObject.spinCard(); //model spins the cards
			viewObject.pickWord(modelObject.getV());
			viewObject.setCount("Words left: "+modelObject.getRestOfWords());
			viewObject.getAnswer().setEnabled(true);
			viewObject.getNote().setEnabled(true);
			viewObject.getExamNote().setEnabled(true);
			if(modelObject.finish()) {
				viewObject.setCount("");
				viewObject.getPick().setEnabled(false);
				viewObject.getAnswer().setEnabled(false);
				viewObject.getNote().setEnabled(false);
				viewObject.getExamNote().setEnabled(true);
			}
		}
		
		if (e.getSource() == viewObject.getAnswer()) {	//if new game button is clicked
			viewObject.showAnswer(modelObject.getA());	//view reset the game
		
		}
		
		if (e.getSource() == viewObject.getNote()) {
			viewObject.getNote().setEnabled(false);//if new game button is clicked
			modelObject.setNote();	//view reset the game
		}
		
		if (e.getSource() == viewObject.getExamNote()) {
			if(modelObject.enableExamNote()) {
				modelObject.spinCard();
				viewObject.setCount("Words left: "+modelObject.getRestOfWords());
				viewObject.pickWord(modelObject.getV());
				viewObject.getPick().setEnabled(true);
				viewObject.getAnswer().setEnabled(true);
				viewObject.getNote().setEnabled(true);
				viewObject.getExamNote().setEnabled(false);
			}else {
				viewObject.setCount("");
				viewObject.pickWord(modelObject.getV());
				viewObject.getPick().setEnabled(false);
				viewObject.getAnswer().setEnabled(false);
				viewObject.getNote().setEnabled(false);
				viewObject.getExamNote().setEnabled(false);
			}
		}
			
			
		
		if (e.getSource() == viewObject.getRestart()) {
			modelObject.restart();
			viewObject.restart();
		}
		
		
	}
}