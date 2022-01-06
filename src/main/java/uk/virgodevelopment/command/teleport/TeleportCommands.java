package uk.virgodevelopment.command.teleport;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import org.bukkit.entity.Player;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.util.CC;

public class TeleportCommands {

    @Command(label = "teleport", aliases = { "tp"}, permission = "essentials.command.teleport")
    public void teleport(BukkitCommandExecutor executor, Player target) {
        executor.getPlayer().teleport(target);

        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("teleport.player"))
                .replace("%player%", target.getPlayer().getName()));
    }

    @Command(label = "teleporthere", aliases = {"tphere"}, permission = "essentials.command.teleporthere")
    public void teleportHere(BukkitCommandExecutor executor, Player target) {
        target.teleport(executor.getPlayer());

        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("teleport.here"))
                .replace("%player%", target.getPlayer().getName()));
    }
}
