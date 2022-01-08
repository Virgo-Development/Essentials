package uk.virgodevelopment.listener;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.command.chat.state.ChatState;
import uk.virgodevelopment.util.CC;

@RequiredArgsConstructor
@Getter
public class ChatListener implements Listener {

    private final ChatState chatState;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();

        if (!player.hasPermission("essentials.chat.bypass") && this.chatState.isMuted()) {
            player.sendMessage(CC.translate(EssentialSpigotPlugin.getInstance().getConfig().getString("chat.muted.message")));
            event.setCancelled(true);
        }
    }
}
