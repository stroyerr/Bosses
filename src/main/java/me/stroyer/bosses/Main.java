package me.stroyer.bosses;

import me.stroyer.bosses.Bosses.Types.FlyingSkeleton.FSListener;
import me.stroyer.bosses.Bosses.Types.FlyingSkeleton.FlyingSkeleton;
import me.stroyer.bosses.Commands.boss;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("boss").setExecutor(new boss(this));
        getServer().getPluginManager().registerEvents(new FSListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        FlyingSkeleton.killBoss();
    }
}
