package uk.virgodevelopment.command.chat;

import io.github.nosequel.command.annotation.Command;
import io.github.nosequel.command.annotation.Help;
import io.github.nosequel.command.annotation.Subcommand;
import io.github.nosequel.command.bukkit.executor.BukkitCommandExecutor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.command.chat.state.ChatState;
import uk.virgodevelopment.util.CC;

@RequiredArgsConstructor
@Getter
public class ChatCommands {

    private final ChatState chatState;

    @Help
    @Command(label = "chat", permission = "essentials.command.chat")
    public void chat(BukkitCommandExecutor executor) {

    }

    @Command(label = "clear", permission = "essentials.command.chat.clear")
    @Subcommand(label = "clear", parentLabel = "chat", permission = "essentials.command.chat.clear", description = "Clear the chat")
    public void clear(BukkitCommandExecutor executor) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 1000; i++) {
                player.sendMessage("");
            }
        }

        executor.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("chat.clear.message")));
        Bukkit.broadcastMessage(EssentialSpigotPlugin.getInstance().getConfig().getString("chat.clear.broadcast"));
    }

    @Command(label = "mutechat", permission = "essentials.command.chat.mute")
    @Subcommand(label = "mute", parentLabel = "chat", permission = "essentials.command.chat.mute", description = "Mute the chat", weight = 1)
    public void mute(BukkitCommandExecutor executor) {
        if (!chatState.isMuted()) {
            chatState.setMuted(true);
            Bukkit.broadcastMessage(EssentialSpigotPlugin.getInstance().getConfig().getString("chat.muted.enabled"));
            return;
        }
        chatState.setMuted(false);
        Bukkit.broadcastMessage(EssentialSpigotPlugin.getInstance().getConfig().getString("chat.muted.disabled"));
    }
}
