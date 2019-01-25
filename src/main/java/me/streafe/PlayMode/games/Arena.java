package me.streafe.PlayMode.games;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private List<UUID> players = new ArrayList<>();

    private Location spawnLocation;
    private Location lobby;

    public Arena(Location spawn, Location lobby){
        this.spawnLocation = spawn;
        this.lobby = lobby;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public void setPlayers(List<UUID> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        if(players.contains(player.getUniqueId())) return;
        players.add(player.getUniqueId());
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public Location getlobbyLocation() {
        return lobby;
    }

    public void setLobbyLocation(Location lobby) {
        this.lobby = lobby;
    }
}
