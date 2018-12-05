package com.ua.lysenko.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ua.lysenko.task.entity.Event;
import com.ua.lysenko.task.json.JsonManager;

public class EventListModification {
	private JsonManager<Event> manager;
	private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("mm:ss");
	private List<Event> list;

	public EventListModification(JsonManager<Event> manager) {
		this.manager = manager;
	}

	public Map<Integer, List<String>> packagingEvents() {
		list = manager.deserializeJsonFile();

		Map<Integer, List<String>> secondToMsg = new HashMap<>();
		for (Event e : list) {
			DateTime dt = FORMATTER.parseDateTime(e.getTime());
			int i = dt.getSecondOfDay();
			if (secondToMsg.get(i) == null) {
				List<String> s = new ArrayList<>();
				s.add(e.getTime() + " > " + e.getEventName());
				secondToMsg.put(i, s);
			} else {
				secondToMsg.get(i).add(e.getTime() + " > " + e.getEventName());
			}
		}
		return secondToMsg;
	}

	public int eventsAmount() {
		return list.size();
	}
}
