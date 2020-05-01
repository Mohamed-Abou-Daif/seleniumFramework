package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public String firstName, lastName, email, password;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		
		File srcFile = new File(filePath);
		
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray)parser.parse(new FileReader(srcFile));
		
		for (Object jsonObj: jArray) {
			
			JSONObject pesron = (JSONObject) jsonObj;
			firstName = (String) pesron.get("firstName");
			System.out.println(firstName);
			lastName = (String) pesron.get("lastName");
			System.out.println(lastName);
			email = (String) pesron.get("email");
			System.out.println(email);
			password = (String) pesron.get("password");
			System.out.println(password);
		}
		}
}
