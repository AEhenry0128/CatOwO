package org.aehenry.CatOwO;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new chestOpenListener(), this);
    }

}