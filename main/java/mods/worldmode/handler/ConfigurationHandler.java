package mods.worldmode.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import mods.worldmode.reference.ConfigSettings;
import mods.worldmode.reference.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;


    public static void init(File configFile) {

        //create configuration object from the given file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        ConfigSettings.gamemode = configuration.getInt("gamemode", Configuration.CATEGORY_GENERAL, ConfigSettings.defaultGamemode, 0, 3, "Gamemode for the game");
        ConfigSettings.isHardcore = configuration.getInt("isHardcore", Configuration.CATEGORY_GENERAL, ConfigSettings.defaultIsHardcore, 0, 1,"Set 1 if hardcore and 0 if not");
        ConfigSettings.difficulty = configuration.getInt("difficulty", Configuration.CATEGORY_GENERAL, ConfigSettings.deafaultDifficulty, 0, 2,"Difficulty");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}