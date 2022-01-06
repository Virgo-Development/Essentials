package uk.virgodevelopment.command.gamemode.adapter;

import io.github.nosequel.command.adapter.TypeAdapter;
import io.github.nosequel.command.executor.CommandExecutor;
import org.bukkit.GameMode;

public class GamemodeTypeAdapter implements TypeAdapter<GameMode> {

    @Override
    public GameMode convert(CommandExecutor commandExecutor, String source) throws Exception {
        for (GameMode gameMode : GameMode.values()) {
            if (gameMode.name().startsWith(source.toUpperCase())) {
                return gameMode;
            }
        }

        return GameMode.valueOf(source.toUpperCase());
    }
}
