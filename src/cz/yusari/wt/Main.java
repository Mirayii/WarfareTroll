/***********************************
 *
 * WarfareTroll for Advertisment Video created by Yusari mc.warfaremc.eu (Bad code af)
 *
 ************************************/

package cz.yusari.wt;

import cz.yusari.wt.commands.WTCommand;
import cz.yusari.wt.guis.MainMenuGUI;
import cz.yusari.wt.guis.TrollBlocks;
import cz.yusari.wt.guis.TrollItems;
import cz.yusari.wt.listeners.TrollItemsListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance = null;

    @Override
    public void onEnable() {
        instance = this;
        loadEvents();
        loadCommands();
    }
    @Override
    public void onDisable() {

    }
    public void loadEvents() {
        getServer().getPluginManager().registerEvents(new MainMenuGUI(), this);
        getServer().getPluginManager().registerEvents(new TrollBlocks(), this);
        getServer().getPluginManager().registerEvents(new TrollItems(), this);
        getServer().getPluginManager().registerEvents(new TrollItemsListener(), this);
    }
    public void loadCommands() {
        this.getCommand("wt").setExecutor(new WTCommand());
    }
    public static Main getInstance() {
        return instance;
    }
}
