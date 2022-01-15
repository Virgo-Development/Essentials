package uk.virgodevelopment.command.freeze;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import org.bukkit.entity.Player;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.freeze.Freeze;
import uk.virgodevelopment.util.CC;

public class FreezeCommands {

    @Command(label = "freeze", aliases = { "ss"}, permission = "essentials.command.freeze")
    public void freeze(BukkitCommandExecutor executor, Player target) {
        final Freeze freeze = EssentialSpigotPlugin.getInstance().getEssentialBoostrap().getFreeze();

        final String message = freeze.isFrozen(target)
                ? CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("freeze.player.unfrozen"))
                : CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("freeze.player.frozen"));

        freeze.setFrozen(target, !freeze.isFrozen(target));
        target.sendMessage(message);
    }
}
