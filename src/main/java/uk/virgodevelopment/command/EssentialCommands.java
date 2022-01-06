package uk.virgodevelopment.command;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.util.CC;

public class EssentialCommands {

    @Command(label = "discord", aliases = { "dc"})
    public void discord(BukkitCommandExecutor executor) {
        executor.getPlayer().sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("messages.discord")));
    }
}
