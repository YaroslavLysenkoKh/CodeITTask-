package com.ua.lysenko.task;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import com.ua.lysenko.task.json.impl.JsonManagerImpl;
import com.ua.lysenko.task.timer.TimerJob;

public class Demo {
	private final static EventListModification mod = new EventListModification(new JsonManagerImpl());

	private static void start() {
		Timer timer = new Timer();
		Map<Integer, List<String>> map = mod.packagingEvents();
		int amount = mod.eventsAmount();
		timer.schedule(new TimerJob(map, () -> timer.cancel(), amount), 0, 1000);

	}

	public static void main(String[] args) throws ParseException {
		start();
	}

}
