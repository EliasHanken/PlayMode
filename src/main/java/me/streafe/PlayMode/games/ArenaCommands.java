package me.streafe.PlayMode.games;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommands implements CommandExecutor {

    private static String prefix = ("§d[§f§lPlayMode§e§d] ");

    private ArenaManager arenaManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                player.sendMessage(prefix + "Use /playmode help for list of commands");
                return true;
            }
            if(args[0].equalsIgnoreCase("help")){
                player.sendMessage(prefix + "/playmode - main command");
                player.sendMessage(prefix + "/playmode help - shows this message");
                player.sendMessage(prefix + "/playmode add <name> - creates an arena");
                player.sendMessage(prefix + "/playmode (duel)/(skywars)/more coming... - play a gamemode");
                player.sendMessage(prefix + "/playmode - main command");
                player.sendMessage(prefix + "/playmode remove <name> - removes an arena");
                player.sendMessage(prefix + "/playmode setlobby <name> - sets lobby for arena");
                player.sendMessage(prefix + "/playmode setspawn <name> - sets arena spawn");
                player.sendMessage(prefix + "/playmode setmainlobby - sets main lobby");
                return true;
            }
            if(args[0].equalsIgnoreCase("add")){
                if(args.length == 1){
                    player.sendMessage(prefix + "/playmode add <name>");
                    return true;
                }
                String name = args[1];
                if(arenaManager.exists(args[1])){
                    player.sendMessage(prefix + name+ " arena already exists");
                    return true;
                }
                player.sendMessage(prefix + "arena created");
                arenaManager.registerArena(args[1], player.getLocation(), player.getLocation());
                /*
                Entry<String, Integer> entry = new Entry<String, Integer>("Phil", 100);
                player.sendMessage(entry.getValueType().toString());
                */
                return true;

            }
            if(args[0].equalsIgnoreCase("remove")) {
                if(args.length == 1) {
                    sender.sendMessage(prefix + ChatColor.RED + "Use /pvpgame remove <Name>");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(prefix + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.removeArena(args[1]);
                sender.sendMessage(ChatColor.GOLD + "Arena removed.");
                return true;
            }
            if(args[0].equalsIgnoreCase("setspawn")) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(prefix + ChatColor.RED + "This command can only be used by players.");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(prefix + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.getArena(name).setSpawnLocation(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.GOLD + "Spawn set.");
                return true;
            }
            if(args[0].equalsIgnoreCase("setlobby")) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(prefix + ChatColor.RED + "This command can only be used by players.");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(prefix + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.getArena(name).setLobbyLocation(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.GOLD + "Lobby set.");
                return true;
            }
            if(args[0].equalsIgnoreCase("setmainlobby")) {
                sender.sendMessage(ChatColor.GOLD + "Main lobby set.");
                return true;
            }
            sender.sendMessage(prefix + ChatColor.RED + "Unknown subcommand. Use /pvpgame help for a list of commands.");
            return true;
        }

        return true;
    }
}
