package me.streafe.FollowingPets;

import me.streafe.FollowingPets.Pets.PetCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FollowingPets extends JavaPlugin {

    public static FollowingPets instance;

    public void onEnable(){
        instance = this;

        getCommand("pet").setExecutor(new PetCommand());

    }

    public static FollowingPets getInstance() {

        return instance;
    }
}
