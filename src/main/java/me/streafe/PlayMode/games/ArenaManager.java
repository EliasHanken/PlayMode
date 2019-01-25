package me.streafe.PlayMode.games;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class ArenaManager {

    private Map<String, Arena> arenas = new HashMap<>();

    public void registerArena(String name, Location spawnLocation, Location lobbyLocation){
        arenas.put(name, new Arena(spawnLocation, lobbyLocation));
    }

    public void removeArena(String name){
        if(!arenas.containsKey(name)) return;
            arenas.remove(name);
    }

    public Arena getArena(String name){
        return arenas.get(name);
    }

    public void load(){


    }

    public void save(){


    }

    public boolean exists(String name){
        if(arenas.get(name) != null){
            return true;
        }

        return false;
    }
}
