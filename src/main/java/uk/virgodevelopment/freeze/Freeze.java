package uk.virgodevelopment.freeze;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface Freeze {

    List<UUID> frozen = new ArrayList<>();

    void setFrozen(Player player);

    void setFrozen(Player player, boolean bool);

    void removeFrozen(Player player);

    boolean isFrozen(Entity entity);
}
