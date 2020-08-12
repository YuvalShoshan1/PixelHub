package me.Yuval.pixelhub;

import me.Yuval.pixelhub.utils.Utils;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class EventListener implements Listener {
    String prefix = Utils.colour("&3PixelHub &8» ");

    private final PixelHub plugin;

    public EventListener(PixelHub plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void foodEvent(FoodLevelChangeEvent event) {
        if (plugin.getCmd().getHungerToggle()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void damageEvent(EntityDamageEvent event) {
        if (event.getEntityType().equals(EntityType.PLAYER)) {
            if (plugin.getCmd().getDamageToggle()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void weatherEvent(WeatherChangeEvent event) {
        if (plugin.getCmd().getWeatherToggle()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void dropPlayerEvent(PlayerDropItemEvent event) {
        if (plugin.getCmd().getDropPlayerToggle()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void placeEvent(BlockPlaceEvent event) {
        if (plugin.getCmd().getPlayerPlaceToggle()) {
            event.getPlayer().sendMessage(Utils.colour(prefix + "&cSorry, You cannot Place this block!"));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void breakEvent(BlockBreakEvent event) {
        if (plugin.getCmd().getPlayerBreakToggle()) {
            event.getPlayer().sendMessage(Utils.colour(prefix + "&cSorry, You cannot Break this block!"));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        if (plugin.getCmd().getInventoryClickToggle()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void itemPickupEvent(PlayerPickupItemEvent event) {
        if (plugin.getCmd().getPlayerPickupItemToggle()) {
            event.setCancelled(true);
        }
    }
}