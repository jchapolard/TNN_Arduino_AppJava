package com.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;


public class ConnexionManager {

	
	public static Logger log = Logger.getLogger(ConnexionManager.class.getName());
	
	/**
	 * Récupération des données : GET
	 * @return
	 * @throws IOException
	*/
	public Map<String, Object> getDataFireBaseAppareil() throws IOException {
		// TODO : Variabiliser l'URL en fonction du client
		String url = "https://fire-jcd1985.firebaseio.com/appareils.json";
		URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
//		con.setRequestProperty("Accept", "application/json"); // informe le serveur des types de données pouvant être renvoyés. C'est un type MIME.
		con.setRequestProperty("Content-Type", "application/json"); // indique le type de média de la ressource.
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(
		         new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	    //print in String
	    System.out.println(response.toString());
	    //Read JSON response
	    JSONArray jsonArray = new JSONArray(response.toString());
	    Map<String, Object> mapDataNode = new HashMap<>();
	    if(!jsonArray.isEmpty()) {
	    	for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jbResponse = jsonArray.getJSONObject(i);
	            String app_id = "";
	            try {
		            if(jbResponse.getString("app_id") != null && !jbResponse.getString("app_id").isEmpty()) {
		            	app_id = jbResponse.getString("app_id");
		            }
	            } catch (Exception e){
	            	if(String.valueOf(jbResponse.getInt("id")) != null && !String.valueOf(jbResponse.getInt("id")).isEmpty()) {
		            	app_id = String.valueOf(jbResponse.getInt("id"));
		            }
	            }
	            mapDataNode.put(app_id, jbResponse);
//	            String ap_id = jbResponse.getString("app_id");
//	            Integer counter = jbResponse.getInt("counter");
//	   	     	System.out.println("result after Reading JSON Response");
//	   	     	System.out.println("statusCode- "+jbResponse.getString("app_id"));
//	   	     	System.out.println("statusMessage- "+jbResponse.getInt("counter"));
//	   	     	System.out.println("ipAddress- "+jbResponse.getString("dev_id"));
//	   	     	System.out.println("countryCode- "+jbResponse.getString("downlink_url"));
//	   	     	System.out.println("countryName- "+jbResponse.getJSONObject("metadata"));
//	   	    	System.out.println("regionName- "+jbResponse.getJSONObject("payload_fields"));
//	   	     	System.out.println("cityName- "+jbResponse.getInt("port"));
	            
	    	}
	    }
	    return mapDataNode;
	}

}
