package mods.worldmode.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.worldmode.reference.ConfigSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.*;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.WorldEvent;

public class WorldHandler
{
    @SubscribeEvent
    public void worldEvent(WorldEvent.Load event)
    {
        World world = event.world;
        EnumDifficulty enumDifficulty;
        if (ConfigSettings.difficulty == 0)
        {
            world.difficultySetting = EnumDifficulty.PEACEFUL;
        } else if (ConfigSettings.difficulty == 1)
        {
            world.difficultySetting = EnumDifficulty.EASY;
        } else if (ConfigSettings.difficulty == 2)
        {
            world.difficultySetting = EnumDifficulty.NORMAL;
        } else
        {
            world.difficultySetting = EnumDifficulty.HARD;
        }


        if (world.playerEntities.toArray() instanceof EntityPlayer[])
        {
            EntityPlayer[] entityPlayers = (EntityPlayer[])world.playerEntities.toArray();
            for (int i = 0; i > entityPlayers.length; i++)
            {
                if (ConfigSettings.gamemode == 0) {
                    entityPlayers[i].setGameType(WorldSettings.GameType.SURVIVAL);
                } else if (ConfigSettings.gamemode == 1)
                {
                    entityPlayers[i].setGameType(WorldSettings.GameType.CREATIVE);
                } else if (ConfigSettings.gamemode == 2)
                {
                    entityPlayers[i].setGameType(WorldSettings.GameType.ADVENTURE);
                } else
                {
                    entityPlayers[i].setGameType(WorldSettings.GameType.NOT_SET);
                }
            }
        }
        Minecraft mc = Minecraft.getMinecraft();
    }
}
