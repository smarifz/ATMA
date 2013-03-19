package com.app.atma;

import java.util.ArrayList;

public class Database 
{

	ArrayList<Artist> mainArtist;
	
	
	public Database()
	{
		mainArtist = new ArrayList<Artist>();
		
		//Events for Artist Ali
        Event e1 = new Event("event 1", "jan 1st");
    	Event e2 = new Event("event 2", "feb 1st");
        
        //Artist Ali
        Artist ali = new Artist("ali","8187778888");
        ali.addEvent(e1);
        Artist arif = new Artist("arif","8182645477");
        arif.addEvent(e2);
        
        
        mainArtist.add(ali);
        mainArtist.add(arif);
		
	}
	
	public Artist getArtist(int index)
	{
		return mainArtist.get(index);
	}
	
	public void addArtist(Artist newArtist)
	{
		mainArtist.add(newArtist);
	}
	
	public ArrayList<Artist> getArtists()
	{
		return mainArtist;
	}
	
	
}
