package dev.intedai.undergroundpitmod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

public class UPM_Command extends CommandBase {
	private Event[] events;
	
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
        return "\n/upm to see upcoming events\n/upm refresh to fetch api data.";
    }
    
    private void sendString(ICommandSender sender, String string)
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("§6§l------------§b§lUPM§6§l------------\n§r").append(string).append("§r§6§l---------------------------");
    	
    	sender.addChatMessage(new ChatComponentText(sb.toString()));
    	
    }
    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
    	
    	if (args.length == 0)
    	{    		
    		StringBuilder sb = new StringBuilder();
    		
    		int count = 0;
    		for(Event event : events)
    		{
    			if (event.displayEvent())
    			{
    				sb.append(event.toString()).append("\n");
    				count++;
    			}
    			if (count > 12)
    				break;
    		}
    		
    		sendString(sender, sb.toString());
    	}
    	else if (args.length == 1 && args[0].equalsIgnoreCase("refresh"))
    	{
    		refreshEvents();
    		sendString(sender, "§aFetched data from BrookeAFK's API.\n");
    	}
    	else
    	{
    		throw new WrongUsageException(getCommandUsage(sender));
    	}
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}