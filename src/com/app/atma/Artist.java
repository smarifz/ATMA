package com.app.atma;

import java.util.ArrayList;

public class Artist 
{

	String name;
	String number;
	ArrayList<Event> events = new ArrayList<Event>();
	
	public Artist(String name, String number)
	{
		this.name = name;
		this.number = number;
		
	}
	
	public void addEvent(Event newEvent)
	{
		events.add(newEvent);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
}
