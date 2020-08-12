package me.Yuval.pixelhub.gui;

import me.Yuval.pixelhub.PixelHub;
import me.Yuval.pixelhub.utils.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SettingsOther {
    private final Gui settingsOther;
    private final PixelHub plugin;

    //Constructor
    public SettingsOther(PixelHub plugin) {
        this.plugin = plugin;
        settingsOther = new Gui(3, "Other Settings Menu");
    }

    public Gui getOtherGUI() {
        otherItems();
        return settingsOther;
    }

    public void otherItems() {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 7);
        int glassCount = 0;
        while(glassCount < 27) {
            settingsOther.addItem(new GuiItem(ItemBuilder.from(glass).setName(Utils.colour("&7")).build()));
            glassCount++;
        }
        settingsOther.setItem(13, new GuiItem(ItemBuilder
                .from(Material.BARRIER)
                .setName(Utils.colour("&4&n&lComing Soon"))
                .build()));
        settingsOther.setItem(26, new GuiItem(ItemBuilder
                .from(Material.BARRIER)
                .setName(Utils.colour("&8» &c&lBack &8«"))
                .setLore(Utils.colour("&7Right Click &8» &7To go back to the main menu."))
                .build(), event -> {
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            new SettingsMain(plugin).getMainGUI().open(player);
        }));
    }
}
