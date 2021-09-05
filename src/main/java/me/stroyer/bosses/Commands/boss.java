package me.stroyer.bosses.Commands;

import me.stroyer.bosses.Bosses.Spawn;
import me.stroyer.bosses.Main;
import me.stroyer.bosses.Methods.Send;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class boss implements CommandExecutor {

    private Main main;

    public boss(Main main){this.main = main;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){return false;}
        Player p = (Player) sender;
        if(args.length == 0){
            Send.message(p, "Bosses by Stroyer_ for LonelyMC. Use /boss help for commands.");
        }
        if(args.length > 0){
            if(args[0].equalsIgnoreCase("spawn")) {
                if(args.length > 1 && args.length < 3){
                    if(args[1].equalsIgnoreCase("flyingskeleton")){
                        Spawn.spawn(p, "FlyingSkeleton");
                    }
                }else{
                    Send.message(p, "Invalid Syntax. Use /boss spawn <Boss>");
                }

            }
        }



        return true;
    }
}
