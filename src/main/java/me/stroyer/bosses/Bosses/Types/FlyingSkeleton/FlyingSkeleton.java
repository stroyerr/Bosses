package me.stroyer.bosses.Bosses.Types.FlyingSkeleton;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class FlyingSkeleton {

    public static Entity bee;
    public static Entity skeleton;
    public static LivingEntity beeLive;
    public static LivingEntity skelLive;
    public int phase;
    public Scoreboard sb;

    public FlyingSkeleton(Player p){
        Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.RED + "A wild " + ChatColor.GOLD + "Flying Skeleton " + ChatColor.RED + "has locked it's targets on " + p.getName());
        Bee bee = (Bee) p.getWorld().spawnEntity(p.getLocation(), EntityType.BEE);
        skeleton = p.getWorld().spawnEntity(bee.getLocation(), EntityType.SKELETON);
        bee.setInvulnerable(true);
        beeLive = (LivingEntity) bee;
        skelLive = (LivingEntity) skeleton;
        ItemStack helm = new ItemStack(Material.CHAINMAIL_HELMET);
        helm.getItemMeta().setUnbreakable(true);
        skelLive.getEquipment().setHelmet(helm);
        beeLive.setVisualFire(true);
        skelLive.setGlowing(true);
        beeLive.setInvisible(true);
        bee.addPassenger(skeleton);
        Player target = p;
        bee.setAnger(1000);
        bee.setTarget((LivingEntity)((Entity) p));
        phase = 1;

        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = sb.registerNewObjective("currentBoss", "test");

        objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Flying Skeleton");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        double health = skelLive.getHealth();

        Score first= objective.getScore(ChatColor.LIGHT_PURPLE + "Health: " + ChatColor.RED + "" + skelLive.getHealth() + ChatColor.BLACK + "" + ChatColor.MAGIC);
        Score second = objective.getScore(ChatColor.LIGHT_PURPLE + "Current Stage: " + ChatColor.RED + "1/3" + ChatColor.BLACK + "" + ChatColor.MAGIC);
        Score third = objective.getScore(ChatColor.YELLOW + "Damage his helmet!" + ChatColor.BLACK + "" + ChatColor.MAGIC);

        first.setScore(2);
        second.setScore(1);
        third.setScore(0);

        p.setScoreboard(sb);


        FlyingSkeletons.list.add(this);


    }

    public void startPhaseTwo(){

    }

    public static void killBoss(){
        beeLive.damage(200);
        skelLive.damage(200);
    }
}
