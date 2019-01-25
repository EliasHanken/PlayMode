package me.streafe.FollowingPets.kits;

import org.bukkit.inventory.Inventory;

public class SerializationUtil {

    private static String InventoryStringDeSerializer(Inventory inventory){

        String serialization = inventory.getSize() + ";";



        return serialization;
    }
}
