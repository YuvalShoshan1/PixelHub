package me.Yuval.pixelhub.gui;

import me.Yuval.pixelhub.PixelHub;
import me.Yuval.pixelhub.utils.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SettingsPlayer {
    private final Gui settingsPlayer;
    private final PixelHub plugin;


    //Constructor
    public SettingsPlayer(PixelHub plugin) {
        this.plugin = plugin;
        settingsPlayer = new Gui(3, "Player Settings Menu");
    }

    public Gui getPlayerGUI() {
        playerItems();
        return settingsPlayer;
    }

    public void playerItems() {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 7);
        int glassCount = 0;
        while(glassCount < 27) {
            settingsPlayer.addItem(new GuiItem(ItemBuilder.from(glass).setName(Utils.colour("&7")).build()));
            glassCount++;
        }
        settingsPlayer.setItem(13, new GuiItem(ItemBuilder
                .from(Material.STAINED_GLASS_PANE)
                .setName(Utils.colour("&3&lHunger &8(" + plugin.getCmd().getHungerToggle() + "&8)"))
                .build()));
        if (plugin.getCmd().getHungerToggle()) {
            settingsPlayer.setItem(13, ItemBuilder
                    .from(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 5)).asGuiItem());
            settingsPlayer.update();
        } else {
            settingsPlayer.setItem(13, (ItemBuilder
                    .from(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 5)).asGuiItem()));
            settingsPlayer.update();
        }
    }
}

