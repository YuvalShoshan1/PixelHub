package me.Yuval.pixelhub;

import me.Yuval.pixelhub.gui.SettingsMain;
import me.Yuval.pixelhub.utils.Utils;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Command("settings")
public class Commands extends CommandBase {
    private final PixelHub plugin;
    String prefix = Utils.colour("&3PixelHub &8» ");
    HelpMSG helpMSG = new HelpMSG();
    private boolean hungerToggle = true;
    private boolean weatherToggle = true;
    private boolean damageToggle = true;
    private boolean dropPlayerToggle = true;
    private boolean playerPlaceToggle = true;
    private boolean playerBreakToggle = true;
    private boolean inventoryClickToggle = true;
    private boolean playerPickupItemToggle = true;
    private Player viewer;

    public Commands(PixelHub plugin) {
        this.plugin = plugin;
    }

    public boolean getWeatherToggle() {
        return weatherToggle;
    }
    public boolean getDamageToggle() {
        return damageToggle;
    }
    public boolean getHungerToggle() {
        return hungerToggle;
    }
    public boolean getDropPlayerToggle() {
        return dropPlayerToggle;
    }
    public boolean getPlayerPlaceToggle() {
        return playerPlaceToggle;
    }
    public boolean getPlayerBreakToggle() {
        return playerBreakToggle;
    }
    public boolean getInventoryClickToggle() {
        return inventoryClickToggle;
    }
    public boolean getPlayerPickupItemToggle() {
        return playerPickupItemToggle;
    }

    public Player getViewer() {
        return viewer;
    }

    @Default
    public void defaultCommand(Player player) {
        this.viewer = player;
        new SettingsMain(plugin).getMainGUI().open(player);
    }

    @SubCommand("hunger")
    @Permission("ph.settings.hunger")
    public void toggleHunger(Player player) {
        hungerToggle = !hungerToggle;
        player.sendMessage(Utils.colour( prefix + "&7Cancelling set to " + "&3" + hungerToggle + "&7!"));
        if(hungerToggle){
            for (Player player1: Bukkit.getOnlinePlayers()) {
                player1.setFoodLevel(20);
            }
        }
        }

    @SubCommand("weather")
    @Permission("ph.settings.weather")
    public void toggleWeather(Player player) {
        weatherToggle = !weatherToggle;
            player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + weatherToggle + "&7!"));
        }

    @SubCommand("damage")
    @Permission("ph.settings.damage")
    public void toggleDamage(Player player) {
        damageToggle = !damageToggle;
            player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + damageToggle + "&7!"));
        }
    @SubCommand("playerdrop")
    @Permission("ph.settings.playerdrop")
    public void toggleDropPlayer(Player player) {
        dropPlayerToggle = !dropPlayerToggle;
        player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + dropPlayerToggle + "&7!"));
    }
    @SubCommand("place")
    @Permission("ph.settings.place")
    public void placeEvent(Player player) {
        playerPlaceToggle = !playerPlaceToggle;
        player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + playerPlaceToggle + "&7!"));
    }
    @SubCommand("break")
    @Permission("ph.settings.break")
    public void breakEvent(Player player) {
        playerBreakToggle = !playerBreakToggle;
        player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + playerBreakToggle + "&7!"));
    }
    @SubCommand("MoveItem")
    @Permission("ph.settings.moveitem")
    public void inventoryClickEvent (Player player) {
        inventoryClickToggle = !inventoryClickToggle;
        player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + inventoryClickToggle + "&7!"));
    }
    @SubCommand("Pickup")
    @Permission("ph.settings.pickup")
    public void itemPickupEvent (Player player) {
        playerPickupItemToggle = !playerPickupItemToggle;
        player.sendMessage(Utils.colour(prefix + "&7Cancelling set to " + "&3" + playerPickupItemToggle + "&7!"));
    }
    @SubCommand("help")
    public void helpMSG(Player player) {
        player.sendMessage(helpMSG.getHelpMSG());
    }
    }

