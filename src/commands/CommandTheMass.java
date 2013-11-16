package com.eyeofender.themass.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eyeofender.themass.TheMass;


public class CommandTheMass extends TMCommand {

    public CommandTheMass(TheMass instance) {
        super(instance);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0 || args[0].equalsIgnoreCase("version"))
            return sendMsg(sender, "Running version " + ChatColor.LIGHT_PURPLE + plugin.getDescription().getVersion() +
                    " by " + ChatColor.BLUE + "Avery246813579");
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player && !sender.hasPermission("themass.reload"))
                return sendMsg(sender, ChatColor.RED + "Access denied.");
            plugin.reloadServerGroups();
            return sendMsg(sender, ChatColor.GREEN + "Reloaded the config.");
        }
        return false;
    }
}
