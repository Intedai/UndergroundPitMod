package dev.intedai.undergroundpitmod;

public class Utils {
	public static String timeUntilString(long timeUntil)
	{
		long days = timeUntil / (1000 * 60 * 60 * 24);
		long hours   = timeUntil / (1000 * 60 * 60) % 24;
		long minutes = timeUntil / (1000 * 60) % 60;
        long seconds = timeUntil / 1000 % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if (days > 0)
        	sb.append(days).append("d ");
        if (hours > 0)
        	sb.append(hours).append("h ");
        if (hours > 0 || minutes > 0)
        	sb.append(minutes).append("m ");
        sb.append(seconds).append("s");
        
        return sb.toString().trim();
    }
}
