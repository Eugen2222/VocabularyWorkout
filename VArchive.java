import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class VArchive {
	private ArrayList <String> fCol = new ArrayList <String>();
	private ArrayList <String> sCol = new ArrayList <String>();
	
	public VArchive(String address){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        try {
            br = new BufferedReader(new FileReader(address));
            while ((line = br.readLine()) != null) {
                // use comma as separator
            	String [] cache = line.split(cvsSplitBy);
            	fCol.add(cache[0]);
            	if(cache.length>1) {
            		sCol.add(cache[1]);
            	}
            	else {
            		sCol.add("");
            	}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public ArrayList <String> getFirstColum(){
		return fCol;
	}

	public ArrayList <String> getSecondColum(){
		return sCol;
	}
}
