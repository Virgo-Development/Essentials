package uk.virgodevelopment.command.gamemode;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import org.bukkit.GameMode;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.util.CC;

public class GamemodeCommand {

    @Command(label = "gamemode", aliases = { "g", "gm"}, permission = "essentials.command.gamemode", userOnly = true)
    public void gamemode(BukkitCommandExecutor executor, GameMode gameMode) {
        executor.getPlayer().setGameMode(gameMode);
        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("gamemode.updated")
                .replace("%gamemode%", gameMode.name())));
    }
}
