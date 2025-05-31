package org.aehenry.CatOwO;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.util.Vector;


public class chestOpenListener implements Listener {

    @EventHandler
    public void onChestOpen(PlayerInteractEvent event) {

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        Material type = block.getType();

        if (type == Material.CHEST || type == Material.TRAPPED_CHEST ) {

            Location above = block.getLocation().add(0.5, 1.5, 0.5);

            for (Entity e : block.getLocation().getWorld().getNearbyEntities(above, 0.8, 1.0, 0.8)) {
                if (e instanceof Cat cat && cat.isSitting()) {

                    BlockFace chestFacing = ((Directional) block.getBlockData()).getFacing();
                    Vector v = chestFacing.getOppositeFace().getDirection().multiply(0.5).add(new Vector(0.0, 0.5, 0.0));
                    cat.setSitting(false);
                    cat.setVelocity(v);
                    cat.getWorld().spawnParticle(Particle.CLOUD, cat.getLocation(), 10, 0, 0, 0, 0.1);
                }
            }


        }

    }
}
