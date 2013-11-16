package com.eyeofender.themass.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.eyeofender.themass.TheMass;

public abstract class TMCommand implements CommandExecutor {

    protected TheMass plugin;

    protected TMCommand(TheMass instance) {
        plugin = instance;
    }

    protected boolean sendMsg(CommandSender sender, String msg) {
        sender.sendMessage(TheMass.PREFIX + msg);
        return true;
    }
}
