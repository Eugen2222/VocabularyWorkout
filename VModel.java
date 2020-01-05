//Name: WEI-TING, LIN
//Matric: 2434295l

import java.util.ArrayList;
import java.util.Random;

//This class stores the game data and the interactive methods.
public class VModel {
	private VArchive file; //read file
	private String v = new String(); //current word
	private String a = new String(); //current answer
	private ArrayList <String> vPool = new ArrayList <String>();//vocabulary pool
	private ArrayList <String> aPool = new ArrayList <String>();//translation
	private ArrayList <Integer> index =  new ArrayList <Integer>();
	private ArrayList <Integer> noteIndex =  new ArrayList <Integer>();
	private ArrayList <Integer> tempNote =  new ArrayList <Integer>();
	private int noteSize = 0;
	private int currentIndex = 0;
	private int restOfWords;
	private boolean finishStatus = false;
	private boolean examStatus = false;
	//Create a player point.
	private int point; 
	//Create a String to store player's status.
	//A constructor to default the game.
	
	public VModel(String path) {
		file = new VArchive(path); //read file
		vPool = file.getFirstColum();
		aPool = file.getSecondColum();
		restOfWords = vPool.size();
		restart();//Call the new game method to initialize a new game.
	}
	
	//Initialize a new game.
	
	
	//Change player's card and calculate the player's point..
	public void spinCard() {
		//Use random object to generate a random number.
		if(examStatus==true) {
			if(restOfWords == 0) {
				v = "Finish exam!!!";
				finishStatus = true;
				noteIndex = tempNote;
			}else {
				while(!noteIndex.contains(pickIndex(vPool.size())));
				v = vPool.get(currentIndex);
				a = aPool.get(currentIndex);
				noteIndex.remove(noteIndex.indexOf(currentIndex));
				restOfWords--;
			}
		}else {
			if(restOfWords == 0) {
				v = "Finish!!!";
				finishStatus = true;
			}else {
				while(index.contains(pickIndex(vPool.size())));
				v = vPool.get(currentIndex);
				a = aPool.get(currentIndex);
				index.add(currentIndex);
				restOfWords--;
			}
		}
	}
	public int pickIndex(int size) {
		Random r = new Random();
		currentIndex = r.nextInt(size);
		System.out.println(currentIndex);
		return currentIndex;
	}
	
	public String getV() {
		return v;
	}
	
	public String getA() {
		return a;
	}
	
	public boolean finish() {
		return finishStatus;
	}
	
	public void setNote() {
		if(examStatus==true) {
			tempNote.add(currentIndex);
		}else {
			noteIndex.add(currentIndex);
			System.out.print(currentIndex);
		}

	}
	
	public boolean enableExamNote() {
		if(noteIndex.size()==0) {
			v="No Note!!";
			return false;
		}else {
			examStatus = true;
			finishStatus = false;
			index.clear();
			restOfWords = noteIndex.size();
			noteSize = noteIndex.size();
			return true;
		}
	}
	
	public void restart() {
		noteIndex.clear();;
		index.clear();
		examStatus = false;
		finishStatus = false;
		restOfWords = vPool.size();
		noteSize= 0;
	}
}



