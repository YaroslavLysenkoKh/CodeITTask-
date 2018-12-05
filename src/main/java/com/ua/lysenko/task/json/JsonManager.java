package com.ua.lysenko.task.json;

import java.util.List;

public interface JsonManager<T> {
	List<T> deserializeJsonFile();
}
