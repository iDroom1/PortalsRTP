package org.idroom.portalrtp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PortalListener implements Listener {

    private final PortalManager portalManager;

    public PortalListener(PortalRTP plugin) {
        this.portalManager = new PortalManager(plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location playerLoc = event.getPlayer().getLocation();

        // Debug message to show player's location
        // System.out.println("Player Location: " + playerLoc);

        // Check if player is in the portal region
        if (portalManager.isInPortalRegion(playerLoc)) {
            // Debug message if player is inside the portal region
            System.out.println("Player is inside the portal region.");

            // Send a message to the player for debugging
            event.getPlayer().sendMessage("You are inside the portal region!");

            // Teleport player to a random location using BetterRTP
            portalManager.teleportPlayerToRandomLocation(event.getPlayer());
        }
    }
}
