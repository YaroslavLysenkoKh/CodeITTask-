package com.ua.lysenko.task.entity;

public class Event {

	private String eventName;
	private String time;

	public void setTime(String time) {
		this.time = time;
	}

	public Event(String eventName, String time) {
		super();
		this.eventName = eventName;
		this.time = time;
	}

	public Event() {
		super();
	}

	public String getTime() {
		return time;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return " Event -> " + eventName;
	}
}
