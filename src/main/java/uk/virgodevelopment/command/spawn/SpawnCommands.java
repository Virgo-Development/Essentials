package uk.virgodevelopment.command.spawn;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.util.CC;

public class SpawnCommands {

    @Command(label = "spawn", permission = "essentials.command.spanw")
    public void spawn(BukkitCommandExecutor executor) {
        executor.getPlayer().teleport(executor.getPlayer().getWorld().getSpawnLocation());

        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("spawn.teleport")));
    }

    @Command(label = "setspawn", permission = "essentials.command.setspawn")
    public void setSpawn(BukkitCommandExecutor executor) {
        final Player player = executor.getPlayer();
        final Location location = player.getLocation();

        location.getWorld().setSpawnLocation(
                location.getBlockX(),
                location.getBlockY(),
                location.getBlockZ()
        );

        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("spawn.setspawn")));
    }
}
