package me.stroyer.bosses.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Send {
    public static void message(Player p, String msg){
        p.sendMessage(ChatColor.GOLD + "Bosses" + ChatColor.GRAY + " // " + ChatColor.RED + msg);
    }
}
