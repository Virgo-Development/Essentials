package uk.virgodevelopment;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import uk.virgodevelopment.bootstrap.EssentialBoostrap;

@Getter
public class EssentialSpigotPlugin extends JavaPlugin {

    private static EssentialSpigotPlugin instance;

    private EssentialBoostrap essentialBoostrap;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();

        this.essentialBoostrap = new EssentialBoostrap();
    }

    public static EssentialSpigotPlugin getInstance() {
        return instance;
    }
}
