package me.streafe.PlayMode;

import me.streafe.PlayMode.Pets.PetCommand;
import me.streafe.PlayMode.games.ArenaCommands;
import me.streafe.PlayMode.games.ArenaManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayMode extends JavaPlugin {

    public static PlayMode instance;


    public void onEnable(){
        instance = this;

        getCommand("pet").setExecutor(new PetCommand());
        getCommand("playmode").setExecutor(new ArenaCommands());

    }

    public static PlayMode getInstance() {

        return instance;
    }
}
