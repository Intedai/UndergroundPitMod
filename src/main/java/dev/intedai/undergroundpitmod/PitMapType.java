package dev.intedai.undergroundpitmod;

public enum PitMapType {
    GENESIS("Genesis", "§e"),
    CORALS("Corals", "§9"),
    CASTLE("Castle", "§c"),
    ELEMENTS("Elements", "§2"),
    FOUR_SEASONS("Four Seasons", "§6");

	private final String name;
	private final String color;
	
	PitMapType(String name, String color)
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
}
