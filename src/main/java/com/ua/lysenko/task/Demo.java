package com.ua.lysenko.task;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import com.ua.lysenko.task.entity.Event;
import com.ua.lysenko.task.json.JsonManager;
import com.ua.lysenko.task.json.impl.JsonManagerImpl;
import com.ua.lysenko.task.timer.TimerJob;

public class Demo {

	private static void start() {
		Timer timer = new Timer();
		JsonManager<Event> jsonManager = new JsonManagerImpl();
		EventListModification eventListMod = new EventListModification(jsonManager);
		Map<Integer, List<String>> map = eventListMod.packagingEvents();
		int amount = eventListMod.eventsAmount();
		timer.schedule(new TimerJob(map, () -> timer.cancel(), amount), 0, 1000);

	}

	public static void main(String[] args) throws ParseException {
		start();
	}

}
