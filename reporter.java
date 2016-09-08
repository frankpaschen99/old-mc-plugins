/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.PluginDescriptionFile
 *  org.bukkit.plugin.java.JavaPlugin
 */
package net.scruffix.reporter;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class main
extends JavaPlugin {
    PluginDescriptionFile pdf;

    public main() {
        this.pdf = this.getDescription();
    }

    public void onEnable() {
        this.getLogger().info("Reporter v" + this.pdf.getVersion() + " " + "loaded!");
    }

    public void onDisable() {
        this.getLogger().info("Reporter v" + this.pdf.getVersion() + " " + "unloaded!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("report")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Command only available to players.");
                return false;
            }
            if (args.length < 1) {
                sender.sendMessage("Too few arguments!");
                return false;
            }
            if (!sender.hasPermission("reporter.report")) {
                sender.sendMessage((Object)ChatColor.RED + "You are missing the required permissions to do this! <reporter.report>");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                String allArgs = sb.toString().trim();
                Bukkit.broadcast((String)((Object)ChatColor.RED + "[Report]" + (Object)ChatColor.BLUE + " " + "[" + sender.getName() + "]" + (Object)ChatColor.RED + " " + allArgs), (String)"reporter.recieve");
                return true;
            }
        }
        return false;
    }
}

