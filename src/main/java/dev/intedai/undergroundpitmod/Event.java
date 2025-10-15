package dev.intedai.undergroundpitmod;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Event {
	private EventType type;
	private long timestamp;
	private boolean isMajor;
	
	private final String STARTING_SOON_PREFIX = "§4§l";
	private final int THREE_MINUTES = 3*60*1000;

	public Event(String typeName, long timestamp, String minorOrMajor)
	{
		this.type = EventType.getType(typeName);
		this.timestamp = timestamp;
		this.isMajor = minorOrMajor.equalsIgnoreCase("major");
	}
	
	public long getTimeUntil()
	{
		long now = System.currentTimeMillis();
		long timeUntil = timestamp - now;
		
		return timeUntil;
	}
	
	public boolean getIsMajor()
	{
		return isMajor;
	}
	
	public EventType getEventType()
	{
		return type;
	}

	public boolean startsSoon(long timeUntil)
	{
		return isMajor && timeUntil < 0 && timeUntil >= -3 * 60 * 1000;
	}
	
	public boolean displayEvent()
	{
		long timeUntil = getTimeUntil();	
		return startsSoon(timeUntil) || timeUntil > 0;
	}
	
	public String eventTimeString()
	{
		Instant instant = Instant.ofEpochMilli(timestamp);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm").withZone(ZoneId.systemDefault());
		
		return formatter.format(instant);
	}
	
	public String timeUntilString(long timeUntil)
	{
		long hours   = timeUntil / (1000 * 60 * 60) % 24;
		long minutes = timeUntil / (1000 * 60) % 60;
        long seconds = timeUntil / 1000 % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if (hours > 0)
        	sb.append(hours).append("h ");
        if (hours > 0 || minutes > 0)
        	sb.append(minutes).append("m ");
        sb.append(seconds).append("s");
        
        return sb.toString().trim();
    }
	
	private String startingSoonUntil(long timeUntil)
	{
		return timeUntilString(THREE_MINUTES + timeUntil);
	}

	@Override
	public String toString()
	{
		long timeUntil = getTimeUntil();
		StringBuilder sb = new StringBuilder();
		
		if (startsSoon(timeUntil))
			sb.append(STARTING_SOON_PREFIX).append(type.getName()).append(" STARTING SOON IN: ").append(startingSoonUntil(timeUntil));
		else
			sb.append(type.getColor()).append("§l").append(type.getName()).append("§r in ").append(timeUntilString(timeUntil)).append(" - ").append(eventTimeString());
		return sb.toString();
	}
}
