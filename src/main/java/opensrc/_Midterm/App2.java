package opensrc._Midterm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import midterm.problem2.RegularExpression;



public class App2
{

	
    public static void main( String[] args ) throws ParseException {
    	Scanner console= new Scanner(System.in);
    	String inputFileName= "midterm.json"; 
    	try {
			FileReader reader = new FileReader(inputFileName);
			Scanner in= new Scanner(reader); 
			String json="";
			while(in.hasNext()) {
				json+=in.nextLine();
			}
			 RegularExpression re = new RegularExpression();

			  JSONParser jsonParser = new JSONParser();
			 JSONObject jsonObject = (JSONObject)jsonParser.parse(json);
			 System.out.print("Enter key: ");
			 Scanner scan=new Scanner(System.in);
			 String key=scan.next();
			 String[] arr=key.split("|");
			  JSONArray infoArray =(JSONArray)jsonObject.get("poem");
			     for(int i=0; i<infoArray.size(); i++) {
			    	 //System.out.println(infoArray.get(i));
			   	 JSONObject itemObject = (JSONObject) infoArray.get(i);
			   	 String str=(String) itemObject.get("item");
			   	 if(str.contains(arr[1]) || re.check(str, arr[0])) {
			   	System.out.println("item "+i+":\t"+itemObject.get("item"));
			   	 	}
			     }
			 
		} catch (FileNotFoundException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
    }
}
