package com.ua.lysenko.task.json.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ua.lysenko.task.entity.Event;
import com.ua.lysenko.task.json.JsonManager;

public class JsonManagerImpl implements JsonManager<Event> {

	public List<Event> deserializeJsonFile() {
		JSONParser parser = new JSONParser();
		List<Event> list = new ArrayList<Event>();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("events.json").getFile());
		JSONArray a;
		try {
			a = (JSONArray) parser.parse(new FileReader(file));
			for (Object o : a) {

				JSONObject event = (JSONObject) o;

				String time = (String) event.get("time");

				String eventName = (String) event.get("eventName");

				list.add(new Event(eventName, time));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}
