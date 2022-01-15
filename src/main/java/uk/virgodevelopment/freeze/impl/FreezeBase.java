package uk.virgodevelopment.freeze.impl;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import uk.virgodevelopment.freeze.Freeze;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class FreezeBase implements Freeze {

    private final Map<UUID, Player> playerMap = new HashMap<>();

    @Override
    public void setFrozen(Player player) {
        this.playerMap.put(player.getUniqueId(), player);
    }

    @Override
    public void setFrozen(Player player, boolean bool) {
        if (bool) {
            this.playerMap.put(player.getUniqueId(), player);
        } else {
            this.playerMap.remove(player.getUniqueId());
        }
    }

    @Override
    public void removeFrozen(Player player) {
        this.playerMap.remove(player.getUniqueId());
    }

    @Override
    public boolean isFrozen(Entity entity) {
        return playerMap.containsKey(entity.getUniqueId());
    }
}
