package cz.yusari.wt.commands;

import cz.yusari.wt.guis.MainMenuGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WTCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        Player p = (Player) sender;
        MainMenuGUI.openMenu(p);
        return false;
    }
}
