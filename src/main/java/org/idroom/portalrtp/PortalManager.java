package org.idroom.portalrtp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PortalManager {

    private final PortalRTP plugin;

    public PortalManager(PortalRTP plugin) {
        this.plugin = plugin;
    }

    public boolean isInPortalRegion(Location loc) {
        // Replace these with your actual portal region coordinates from config
        double x1 = plugin.getConfig().getDouble("portal.pos1.x");
        double y1 = plugin.getConfig().getDouble("portal.pos1.y");
        double z1 = plugin.getConfig().getDouble("portal.pos1.z");
        double x2 = plugin.getConfig().getDouble("portal.pos2.x");
        double y2 = plugin.getConfig().getDouble("portal.pos2.y");
        double z2 = plugin.getConfig().getDouble("portal.pos2.z");

        // Check if the player is within the region defined by pos1 and pos2
        return loc.getX() >= Math.min(x1, x2) && loc.getX() <= Math.max(x1, x2) &&
                loc.getY() >= Math.min(y1, y2) && loc.getY() <= Math.max(y1, y2) &&
                loc.getZ() >= Math.min(z1, z2) && loc.getZ() <= Math.max(z1, z2);
    }

    public void teleportPlayerToRandomLocation(Player player) {
        // Use BetterRTP to teleport the player
        // Make sure BetterRTP is installed and working
        Bukkit.getScheduler().runTask(plugin, () -> {
            // You can use a BetterRTP command to teleport the player
            player.performCommand("rtp");
            // Alternatively, you could directly teleport them if you prefer
            // player.teleport(new Location(player.getWorld(), x, y, z));
        });
    }
}
