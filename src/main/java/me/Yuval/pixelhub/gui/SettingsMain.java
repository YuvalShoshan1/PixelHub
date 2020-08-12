package me.Yuval.pixelhub.gui;

import me.Yuval.pixelhub.PixelHub;
import me.Yuval.pixelhub.utils.Skull;
import me.Yuval.pixelhub.utils.Utils;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class SettingsMain implements Listener {
    private final Gui settingsMain;
    private final PixelHub plugin;

    //Constructor
    public SettingsMain(PixelHub plugin) {
        this.plugin = plugin;
        settingsMain = new Gui(3, "Settings Menu");
    }

    public Gui getMainGUI() {
        mainItems();
        return settingsMain;
    }

    public void mainItems() {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 7);
        int glassCount = 0;
        while(glassCount < 27) {
            settingsMain.addItem(new GuiItem(ItemBuilder.from(glass).setName(Utils.colour("&7")).build()));
            glassCount++;
        }
        settingsMain.setItem(11, new GuiItem(ItemBuilder
                .from(Skull.getPlayerSkull(plugin.getCmd().getViewer().getDisplayName()))
                .setName(Utils.colour("&3&n&lPlayer Settings"))
                .setLore(Utils.colour("&7Right Click &8» &7to open Player Settings Menu."))
                .build(), event -> {
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            new SettingsPlayer(plugin).getPlayerGUI().open(player);
        }));
        settingsMain.setItem(13, new GuiItem(ItemBuilder
                .from(Material.EYE_OF_ENDER)
                .setName(Utils.colour("&3&n&lWorld Settings"))
                .setLore(Utils.colour("&7Right Click &8» &7to open World Settings Menu."))
                .build()));
        settingsMain.setItem(15, new GuiItem(ItemBuilder
                .from(Material.NETHER_STAR)
                .setName(Utils.colour("&3&n&lOther Settings"))
                .setLore(Utils.colour("&7Right Click &8» &7to open Other Settings Menu."))
                .build(), event -> {
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            new SettingsOther(plugin).getOtherGUI().open(player);
        }));
    }
}