package me.Yuval.pixelhub;

import me.Yuval.pixelhub.gui.SettingsMain;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PixelHub extends JavaPlugin {

    Commands cmd;
    EventListener event;

    @Override
    public void onEnable() {
        EventListener eventList = new EventListener(this);
        Bukkit.getServer().getPluginManager().registerEvents(eventList, this);
        Bukkit.getServer().getPluginManager().registerEvents(new SettingsMain(this), this);
        cmd = new Commands(this);
        CommandManager cmdManager = new CommandManager(this);
        cmdManager.register(cmd);
    }
    @Override
    public void onDisable() {
    }

    public Commands getCmd() {
        return cmd;
    }
    public EventListener getEvent() {
        return event;
    }
}
