package com.example.search;

import java.io.Serializable;
import java.util.List;

import com.example.Person;

public interface CalendarDataDao extends Serializable{
	
	public List<Person> search(String title, String start, String end);

}
