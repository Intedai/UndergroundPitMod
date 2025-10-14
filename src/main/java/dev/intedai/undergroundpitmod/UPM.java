package dev.intedai.undergroundpitmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.ClientCommandHandler;

@Mod(modid = UPM.MODID, version = UPM.VERSION)
public class UPM
{
    public static final String MODID = "undergroundpitmod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	ClientCommandHandler.instance.registerCommand(new UPM_Command());
    }
}
