package mods.worldmode.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.worldmode.reference.ConfigSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class LivingHandler
{
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            if (ConfigSettings.isHardcore == 1) {
                event.entity.worldObj.sendQuittingDisconnectingPacket();
                Minecraft mc = Minecraft.getMinecraft();
                mc.loadWorld((WorldClient) null);
                mc.displayGuiScreen(new GuiMainMenu());
            }
        }
    }
}
