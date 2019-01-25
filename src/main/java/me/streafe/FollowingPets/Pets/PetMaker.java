package me.streafe.FollowingPets.Pets;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
import org.bukkit.entity.LivingEntity;

import java.lang.reflect.Field;
import java.util.UUID;

public class PetMaker {

    private static Field gsa;
    private static Field goalSelector;
    private static Field targetSelector;

    static {
        try{
            gsa = PathfinderGoalSelector.class.getDeclaredField("b");
            gsa.setAccessible(true);

            goalSelector = EntityInsentient.class.getDeclaredField("goalSelector");
            goalSelector.setAccessible(true);

            targetSelector = EntityInsentient.class.getDeclaredField("targetSelector");
            targetSelector.setAccessible(true);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void makePet(LivingEntity e, UUID follow){
        try{
            Object nms_entity = ((CraftLivingEntity)e).getHandle();
            if(nms_entity instanceof LivingEntity){
                PathfinderGoalSelector goal = (PathfinderGoalSelector) goalSelector.get(nms_entity);
                PathfinderGoalSelector target = (PathfinderGoalSelector) targetSelector.get(nms_entity);

                gsa.set(goal, new UnsafeList<Object>());
                gsa.set(target, new UnsafeList<Object>());

                goal.a(0, new PathfinderGoalFloat((EntityInsentient) nms_entity));
                //goal.a(1, new PathfinderGoalWalktoTile((EntityInsentient) nms_entity, toFollow));
            }else{
                throw new IllegalAccessException(e.getType().getName() + " is not an istance of an EntityInsentient");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    private static class PathfinderGoalWalktoTile extends PathfinderGoal {

        private EntityInsentient entity;
        private PathEntity path;
        private UUID p;



        public PathfinderGoalWalktoTile(EntityInsentient entityCreature, UUID p) {
            this.entity = entityCreature;
            this.p = p;
        }



        public boolean a() {

            if(Bukkit.getPlayer(p) == null){
                return path != null;
            }

            Location targetLocation = Bukkit.getPlayer(p).getLocation();

            boolean flag = this.entity.getNavigation().a(this.path, 1D);

            /*this.entity.getNavigation().b(false);
            this.path = this.entity.getNavigation().a(targetLocation.getX() + 1, targetLocation.getY(), targetLocation.getZ() + 1);
            this.entity.getNavigation().b(flag);

            */

            return this.path != null;


        }

        @Override
        public void c(){
            this.entity.getNavigation().a(this.path, 1D);
        }


    }
}
