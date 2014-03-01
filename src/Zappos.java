
import java.io.*;
import java.net.*;
import java.util.*;

// used for converting JSON to ZapposItems
import com.google.gson.Gson;
/* this module is to hit the API's, get the data and convert the JSON into java objects*/
public class Zappos {
	
	    	
	public static String httpGet(String urlStr) throws IOException {

		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		if (connection.getResponseCode() != 200) {
			throw new IOException(connection.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder responseString = new StringBuilder();

		String line;
		while ((line = rd.readLine()) != null) 
			responseString.append(line);
		rd.close();

		connection.disconnect();
		return responseString.toString();
	}
	
	public static ZappoBean[] getZapposItemForSearchTerm(String search) {
		
		int limit = 100;
		String URLRequest = search;
		//String URLRequest = "http://api.zappos.com/Search?term=bags&key=52ddafbe3ee659bad97fcce7c53592916a6bfd73";
		Gson gson = new Gson();
		
		ZappoBean[] item = new ZappoBean[limit];

		try {

			String response = httpGet(URLRequest);
			
			SearchResponse theResponse = gson.fromJson(response, SearchResponse.class);
			item = theResponse.getResults();

		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
		
		

		return item;
	} 
	
}
	
	