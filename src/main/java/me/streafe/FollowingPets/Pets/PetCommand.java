package me.streafe.FollowingPets.Pets;

import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;

import java.lang.reflect.Field;

public class PetCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(command.getName().equalsIgnoreCase("pet")){
                if(args.length != 1) return true;

                /*String[] i = {"555", "ttfff"};
                p.sendMessage(i);

                Skeleton skelly = Bukkit.getWorld("world").spawn(p.getLocation(), Skeleton.class);
                String name = "&c&lHorrible Times";
                skelly.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
                skelly.setCustomNameVisible(true);

                */
                Player player = Bukkit.getPlayer(args[0]);
                CraftPlayer pl = (CraftPlayer) player;

                PacketPlayOutNamedEntitySpawn npc = new PacketPlayOutNamedEntitySpawn(pl.getHandle());
                pl.sendMessage("Created a npc with the name " + args[0]);

                try{
                    Field field = npc.getClass().getDeclaredField("a");
                    field.setAccessible(true);

                    field.setInt(npc, 123);
                    field.setAccessible(!field.isAccessible());

                }catch(Exception e){
                    e.printStackTrace();
                }

                pl.getHandle().playerConnection.sendPacket(npc);

            }
        }

        return true;
    }
}
