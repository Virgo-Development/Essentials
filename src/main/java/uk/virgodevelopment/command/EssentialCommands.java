package uk.virgodevelopment.command;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.util.CC;

public class EssentialCommands {

    @Command(label = "discord", aliases = { "dc"})
    public void discord(BukkitCommandExecutor executor) {
        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("messages.discord")));
    }

    @Command(label = "teamspeak", aliases = { "ts"})
    public void teamspeak(BukkitCommandExecutor executor) {
        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("messages.teamspeak")));
    }

    @Command(label = "store")
    public void store(BukkitCommandExecutor executor) {
        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("messages.store")));
    }

    @Command(label = "website", aliases = { "site", "web"})
    public void website(BukkitCommandExecutor executor) {
        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("messages.website")));
    }
}
