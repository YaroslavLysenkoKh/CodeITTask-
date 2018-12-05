package com.ua.lysenko.task.timer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class TimerJob extends TimerTask {

	private static int secondsCounter = 1;
	private static int positionCounter;
	private int tickAmount;
	private final Map<Integer, List<String>> map;
	private Callback callback;

	public TimerJob(Map<Integer, List<String>> map, Callback callback, int amount) {
		super();
		this.callback = callback;
		this.map = map;
		this.tickAmount = amount;
	}

	@Override
	public void run() {
		if (positionCounter < tickAmount) {

			for (Object o : map.getOrDefault(secondsCounter, Collections.emptyList())) {
				System.out.println(o);
				positionCounter++;
			}

		} else {
			callback.callBack();
			System.out.println("********END*********");
		}
		secondsCounter++;
	}

}
