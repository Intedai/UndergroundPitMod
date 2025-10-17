package dev.intedai.undergroundpitmod;

/*
 * Inspired by pit.wiki implementation
 */
public class PitMaps {
	private static final PitMapType MAP_ROTATION[] = PitMapType.values();
	private static final long SAMPLE_MAP_ROTATION = 1661835600000L;
	private static final long WEEK = 7L * 24 * 3600 * 1000;
	
	public static String getMapInfo()
	{
		final long rotationLen = MAP_ROTATION.length * WEEK;
		long now = System.currentTimeMillis();
		long elapsed = now - SAMPLE_MAP_ROTATION;
		
		long timeUntilNext = (rotationLen - (elapsed % rotationLen)) % WEEK;
		int currIdx = (int) ((timeUntilNext / WEEK) % MAP_ROTATION.length);
		int nextIdx = Math.floorMod(currIdx - 1, MAP_ROTATION.length);
		
		StringBuilder sb = new StringBuilder("§7Current map: ")
				.append(MAP_ROTATION[currIdx].getColor())
				.append("§l")
				.append(MAP_ROTATION[currIdx].getName())
				.append("\n")
				.append(MAP_ROTATION[nextIdx].getColor())
				.append("§l")
				.append(MAP_ROTATION[nextIdx].getName())
				.append("§r in ")
				.append(Utils.timeUntilString(timeUntilNext))
				.append("\n");
		
		return sb.toString();
	}
}