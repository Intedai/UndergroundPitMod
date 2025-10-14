package dev.intedai.undergroundpitmod;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializer;

public class HttpGetEvents {
	private static final String API_URL = "https://raw.githubusercontent.com/BrookeAFK/brookeafk-api/refs/heads/main/events.js";
	
	private static final Gson GSON = new GsonBuilder()
			.registerTypeAdapter(Event.class, (JsonDeserializer<Event>)(json, typeOfT, context) -> {
				JsonObject jsonObj = json.getAsJsonObject();
				String eventName = jsonObj.get("event").getAsString();
				long timestamp = jsonObj.get("timestamp").getAsLong();
				String minorOrMajor = jsonObj.get("type").getAsString();
				
				return new Event(eventName, timestamp, minorOrMajor);
			}).create();
	
	public static Event[] fetch()
	{
		StringBuilder sb = new StringBuilder();
		Event[] events = new Event[0];
		try
		{			
			URL url = new URL(API_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
		    try (BufferedReader reader = new BufferedReader(
	            new InputStreamReader(conn.getInputStream()))) {
	            for (String line; (line = reader.readLine()) != null; ) {
	        	    sb.append(line);
	         	}
		    }
		    
		    String jsonStr = sb.toString();
		    events = GSON.fromJson(jsonStr, Event[].class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return events;
	}
}
