/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.PluginDescriptionFile
 *  org.bukkit.plugin.java.JavaPlugin
 */
package me.monkeyfranco.TestPlugin;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin
extends JavaPlugin {
    public static TestPlugin plugin;
    public final Logger logger = Logger.getLogger("Minecraft");

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " has been Disabled.");
    }

    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " Version " + pdfFile.getVersion() + "has been Enabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("wimn")) {
            Player player = (Player)sender;
            player.sendMessage((Object)ChatColor.GOLD + "Your name is" + " " + (Object)ChatColor.AQUA + player.getName() + "," + " " + (Object)ChatColor.GOLD + "your nickname is" + " " + player.getDisplayName());
            if (player instanceof Player && !player.hasPermission("wimn.name")) {
                player.sendMessage((Object)ChatColor.RED + "You do not have permission to use this command.");
            }
        }
        return false;
    }
}

