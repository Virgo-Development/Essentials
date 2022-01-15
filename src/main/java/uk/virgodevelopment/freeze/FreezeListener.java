package uk.virgodevelopment.freeze;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.bootstrap.EssentialBoostrap;
import uk.virgodevelopment.util.CC;

public class FreezeListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        final Entity entity = event.getEntity();
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (entity instanceof Player && freeze.isFrozen(entity)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Entity entity = event.getEntity();
            final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

            if (freeze.isFrozen(entity)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        if (freeze.isFrozen(event.getPlayer())) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (target.hasPermission("essentials.staff")) {
                    target.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("freeze.player.quit"))
                            .replace("%player%", event.getPlayer().getName()));
                }
            }
        }
    }
}
