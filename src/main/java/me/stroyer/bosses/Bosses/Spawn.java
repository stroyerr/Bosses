package me.stroyer.bosses.Bosses;

import me.stroyer.bosses.Bosses.Types.FlyingSkeleton.FlyingSkeleton;
import org.bukkit.entity.Player;

public class Spawn {

    public static FlyingSkeleton fs = null;

    public static void spawn(Player p, String boss){
        if(boss.equalsIgnoreCase("flyingskeleton")){
            fs = new FlyingSkeleton(p);
        }
    }
}
