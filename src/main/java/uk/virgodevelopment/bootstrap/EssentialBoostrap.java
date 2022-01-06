package uk.virgodevelopment.bootstrap;

import io.github.nosequel.command.CommandHandler;
import io.github.nosequel.command.bukkit.BukkitCommandHandler;
import lombok.Getter;
import org.bukkit.GameMode;
import uk.virgodevelopment.command.EssentialCommands;
import uk.virgodevelopment.command.chat.ChatCommands;
import uk.virgodevelopment.command.chat.state.ChatState;
import uk.virgodevelopment.command.gamemode.GamemodeCommand;
import uk.virgodevelopment.command.gamemode.adapter.GamemodeTypeAdapter;
import uk.virgodevelopment.command.teleport.TeleportCommands;

@Getter
public class EssentialBoostrap {

    private final ChatState chatState;

    public EssentialBoostrap() {
        this.chatState = new ChatState();

        final CommandHandler commandHandler = new BukkitCommandHandler("essentials");

        commandHandler.registerTypeAdapter(GameMode.class, new GamemodeTypeAdapter());

        commandHandler.registerCommand(new EssentialCommands());
        commandHandler.registerCommand(new ChatCommands(this.getChatState()));
        commandHandler.registerCommand(new GamemodeCommand());
        commandHandler.registerCommand(new TeleportCommands());
    }
}
