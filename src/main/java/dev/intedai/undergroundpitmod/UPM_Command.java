package dev.intedai.undergroundpitmod;

import java.util.function.Predicate;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

public class UPM_Command extends CommandBase {
	private Event[] events;
	private final int EVENT_COUNT = 12;
	
	public UPM_Command()
	{
		refreshEvents();
	}
	
	private void refreshEvents()
	{
		events = HttpGetEvents.fetch();
	}

    @Override
    public String getCommandName() {
        return "upm";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
    	StringBuilder sb = new StringBuilder("\n/upm to see upcoming events")
    		.append("\n/upm <event name> to see every time the event starts")
    		.append("\n/upm refresh to fetch api data")
    		.append("\n/upm major to see upcoming major events")
    		.append("\n/upm minor to see upcoming minor events")
    		.append("\n/upm map or maps to see current and next map");
    	
    	return sb.toString();
    }
    
    private void sendString(ICommandSender sender, String string)
    {
    	StringBuilder sb = new StringBuilder("§6§l------------§b§lUPM§6§l------------\n§r")
    		.append(string)
    		.append("§r§6§l---------------------------");
    	
    	sender.addChatMessage(new ChatComponentText(sb.toString()));
    	
    }
    
    private String getEventsOnCondition(int count, Predicate<Event> condition)
    {
		StringBuilder sb = new StringBuilder();
		
		int counter = 0;
		for(Event event : events)
		{
			if (event.displayEvent() && condition.test(event))
			{
				sb.append(event.toString()).append("\n");
				counter++;
			}
			if (counter == count)
				break;
		}
		
		return sb.toString();
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
    	
    	if (args.length == 0)
    	{
    		sendString(sender, getEventsOnCondition(EVENT_COUNT, event -> true));
    		return;
    	}
    	
    	else
    	{
    		String joinedArgs = String.join(" ", args).trim();
    		
    		try // Check if user wanted to see specific event
    		{
    			EventType wantedEvent = EventType.getType(joinedArgs);
    			sendString(sender, getEventsOnCondition(EVENT_COUNT, event -> event.getEventType() == wantedEvent));
    			return;
    		}
    		catch (IllegalArgumentException e) // Args are not an event name
    		{
    			if (args.length == 1)
    			{			
    				switch(args[0].toLowerCase())
    				{
	    				case "refresh":
	    					refreshEvents();
	    					sendString(sender, "§aFetched data from BrookeAFK's API.\n");
	    					return;
	    				case "major":
	    					sendString(sender, getEventsOnCondition(EVENT_COUNT, event -> event.getIsMajor()));
	    					return;
	    				case "minor":
	    					sendString(sender, getEventsOnCondition(EVENT_COUNT, event -> !event.getIsMajor()));
	    					return;
	    				case "map":
	    				case "maps":
	    					sendString(sender, PitMaps.getMapInfo());
	    					return;
    				}
    			}
    		}
    	}
    	throw new WrongUsageException(getCommandUsage(sender));
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
