package me.stroyer.bosses.Bosses.Types.FlyingSkeleton;

import me.stroyer.bosses.Bosses.Spawn;
import org.bukkit.Bukkit;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class FSListener implements Listener {

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent e){

        Entity damager;

        List<FlyingSkeleton> list = new ArrayList<FlyingSkeleton>();
        list = FlyingSkeletons.list;
       if(e.getDamager().getType()== EntityType.BEE){
           e.setCancelled(true);
           Bee bee = (Bee) e.getDamager();
           bee.setAnger(1000);
           for(int i = 0; i < bee.getWorld().getEntityCount(); i++){
           }
       }

        Bukkit.broadcastMessage("Event finished and damagee isInstance: " + (e.getEntity() instanceof Player));
    }

}
