package me.streafe.PlayMode.kits;

import org.bukkit.inventory.Inventory;

public class SerializationUtil {

    private static String InventoryStringDeSerializer(Inventory inventory){

        String serialization = inventory.getSize() + ";";



        return serialization;
    }
}
