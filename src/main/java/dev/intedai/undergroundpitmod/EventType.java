package dev.intedai.undergroundpitmod;

public enum EventType {
    CARE_PACKAGE("Care Package", "§6"),
    DOUBLE_REWARDS("2x Rewards", "§a"),
    DRAGON_EGG("Dragon Egg", "§5"),
    KOTH("KOTH", "§3"),
    SPIRE("Spire", "§d"),
    AUCTION("Auction", "§e"),
    SQUADS("Squads", "§9"),
    KOTL("KOTL", "§2"),
    ALL_BOUNTY("All bounty", "§3"),
    GIANT_CAKE("Giant Cake", "§d"),
    BEAST("Beast", "§4"),
    ROBBERY("Robbery", "§8"),
    QUICK_MATHS("Quick Maths", "§5"),
    TEAM_DEATHMATCH("Team Deathmatch", "§5"),
    PIZZA("Pizza", "§6"),
    BLOCKHEAD("Blockhead", "§1"),
    RAFFLE("Raffle", "§b"),
	RAGE_PIT("Rage Pit", "§4");
	
	private final String name;
	private final String color;
	
	EventType(String name, String color)
	{
		this.name = name;
		this.color = color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public static EventType getType(String name)
	{
		for(EventType e: EventType.values())
		{
			if (e.name.equalsIgnoreCase(name))
				return e;
		}
		throw new IllegalArgumentException("Unknown event: "+ name);
	}
}
