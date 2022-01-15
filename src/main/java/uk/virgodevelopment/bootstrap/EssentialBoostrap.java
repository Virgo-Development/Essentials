package uk.virgodevelopment.bootstrap;

import io.github.nosequel.command.CommandHandler;
import io.github.nosequel.command.bukkit.BukkitCommandHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import uk.virgodevelopment.EssentialSpigotPlugin;
import uk.virgodevelopment.command.EssentialCommands;
import uk.virgodevelopment.command.chat.ChatCommands;
import uk.virgodevelopment.command.chat.state.ChatState;
import uk.virgodevelopment.command.freeze.FreezeCommands;
import uk.virgodevelopment.command.gamemode.GamemodeCommand;
import uk.virgodevelopment.command.gamemode.adapter.GamemodeTypeAdapter;
import uk.virgodevelopment.command.spawn.SpawnCommands;
import uk.virgodevelopment.command.teleport.TeleportCommands;
import uk.virgodevelopment.freeze.Freeze;
import uk.virgodevelopment.freeze.FreezeListener;
import uk.virgodevelopment.freeze.impl.FreezeBase;
import uk.virgodevelopment.listener.ChatListener;

@Getter
public class EssentialBoostrap {

    private final ChatState chatState;
    private final Freeze freeze = new FreezeBase();

    public EssentialBoostrap() {
        this.chatState = new ChatState();

        final CommandHandler commandHandler = new BukkitCommandHandler("essentials");

        Bukkit.getPluginManager().registerEvents(new ChatListener(this.chatState), EssentialSpigotPlugin.getInstance());
        Bukkit.getPluginManager().registerEvents(new FreezeListener(), EssentialSpigotPlugin.getInstance());

        commandHandler.registerTypeAdapter(GameMode.class, new GamemodeTypeAdapter());

        commandHandler.registerCommand(new EssentialCommands());
        commandHandler.registerCommand(new ChatCommands(this.getChatState()));
        commandHandler.registerCommand(new GamemodeCommand());
        commandHandler.registerCommand(new TeleportCommands());
        commandHandler.registerCommand(new SpawnCommands());
        commandHandler.registerCommand(new FreezeCommands());
    }
}
