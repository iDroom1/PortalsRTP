package org.idroom.portalrtp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalRTP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the portal listener
        getServer().getPluginManager().registerEvents(new PortalListener(this), this);

        // Debug log to confirm the plugin is enabled
        getLogger().info("PortalRTP plugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PortalRTP plugin disabled.");
    }

    // Handle the /setportal command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setportal")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    String pos = args[0];
                    if (pos.equalsIgnoreCase("pos1")) {
                        // Set pos1 to the player's current location
                        getConfig().set("portal.pos1.x", player.getLocation().getX());
                        getConfig().set("portal.pos1.y", player.getLocation().getY());
                        getConfig().set("portal.pos1.z", player.getLocation().getZ());
                        saveConfig();
                        player.sendMessage("Portal position 1 set at your location!");
                    } else if (pos.equalsIgnoreCase("pos2")) {
                        // Set pos2 to the player's current location
                        getConfig().set("portal.pos2.x", player.getLocation().getX());
                        getConfig().set("portal.pos2.y", player.getLocation().getY());
                        getConfig().set("portal.pos2.z", player.getLocation().getZ());
                        saveConfig();
                        player.sendMessage("Portal position 2 set at your location!");
                    } else {
                        player.sendMessage("Invalid argument. Use /setportal pos1 or /setportal pos2.");
                    }
                } else {
                    player.sendMessage("Please specify 'pos1' or 'pos2'.");
                }
            } else {
                getLogger().info("Only players can use /setportal.");
            }
            return true;
        }
        return false;
    }
}
