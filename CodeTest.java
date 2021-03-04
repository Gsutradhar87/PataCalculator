package com.appraisal.practice;

import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class CodeTest {
	
	public static void main(String[] args) {
	/*String str = "Goutam Sutradhar";
	// Will check count of e
	int cnt= 0;
		for(char c : str.toCharArray()) {
			String cstr = Character.toString(c);
			if(cstr.equals("a")) {
				cnt++;
			}
		}
		System.out.println("Occurance of character e is : "+cnt);
	}*/
		
		//https://api.exchangeratesapi.io/latest?symbols=INR,GBP&base=EUR
		//https://api.exchangeratesapi.io/latest?symbols=INR,GBP&base=USD
		//{"rates":{"INR":89.867,"GBP":0.90333},"base":"EUR","date":"2021-01-05"}
		//{"rates":{"INR":73.2352701491,"GBP":0.736150273},"base":"USD","date":"2021-01-05"}

		try {
			URL obj1 = new URL("https://api.exchangeratesapi.io/latest?symbols=INR,GBP&base=EUR");
			URL obj2 = new URL("https://api.exchangeratesapi.io/latest?symbols=INR,GBP&base=USD");
			HttpURLConnection con = (HttpURLConnection) obj1.openConnection();
			//con.setRequestMethod("GET");
			//con.setRequestProperty("User-Agent", "Mozilla/5.0");
			//con.getResponseCode();
			
			InputStreamReader insr = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(insr);
			String inputLine= "";
			StringBuffer s1 = new StringBuffer();
			while((inputLine = in.readLine())!=null)
				s1.append(inputLine);
	//System.out.println(s1);
			
			con = (HttpURLConnection) obj2.openConnection();
			//con.setRequestMethod("GET");
			//con.setRequestProperty("User-Agent", "Mozilla/5.0");
			//con.getResponseCode();
			
			insr = new InputStreamReader(con.getInputStream());
			in = new BufferedReader(insr);
			inputLine= "";
			StringBuffer s2 = new StringBuffer();
			while((inputLine = in.readLine())!=null)
				s2.append(inputLine);
	//System.out.println(s2);		
			
			JSONObject job= new JSONObject(s1.toString());
			JSONObject jobRates = job.getJSONObject("rates");
			System.out.println("The exchange rate of EUR to INR = "+jobRates.getDouble("INR"));
			
			job= new JSONObject(s2.toString());
			jobRates = job.getJSONObject("rates");
			System.out.println("The exchange rate of USD to INR = "+jobRates.getDouble("INR"));
			
		}catch(Exception e) {}
	}
		
}
