/***********************************
 *
 * WarfareTroll for Advertisment Video created by Yusari mc.warfaremc.eu (Bad code af)
 *
 ************************************/

package cz.yusari.wt;

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

    }
    public void loadCommands() {

    }
    public static Main getInstance() {
        return instance;
    }
}
