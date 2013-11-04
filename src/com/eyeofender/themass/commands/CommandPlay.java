package com.eyeofender.themass.commands;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.ChannelNotRegisteredException;

import com.eyeofender.themass.TheMass;

public class CommandPlay extends TMCommand {

    private Random rand;
    private HashMap<String, List<String>> aliasedServerGroups;
    private HashMap<String, List<String>> donaterGroups;

    public CommandPlay(TheMass instance) {
        super(instance);
        rand = new Random();
        aliasedServerGroups = new HashMap<String, List<String>>();
        donaterGroups = new HashMap<String, List<String>>();
        loadServerGroups();
    }

    public void loadServerGroups() {
        aliasedServerGroups.clear();
        for (String alias : plugin.getConfig().getConfigurationSection("server-groups").getKeys(false)) {
            List<String> servers = plugin.getConfig().getStringList("server-groups." + alias);
            if (servers.size() == 0)
                continue;
            aliasedServerGroups.put(alias.toLowerCase(), servers);
        }
        
        donaterGroups.clear();
        for(String alias : plugin.getConfig().getConfigurationSection("donator-groups").getKeys(false)){
        	List<String> servers = plugin.getConfig().getStringList("donator-groups." + alias);
        	if(servers.size() == 0)
        		continue;
        	donaterGroups.put(alias.toLowerCase(), servers);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return sendMsg(sender, ChatColor.RED + "Restricted: " + ChatColor.GRAY + "must be a player.");
        Player player = (Player) sender;
        if (!player.hasPermission("themass.play"))
            return sendMsg(sender, ChatColor.RED + "Access denied!");
        String server = null;
        if (args.length == 0 || args.length > 2)
            return false;
        String group = args[0].toLowerCase();
        
        List<String> servers = aliasedServerGroups.get(group);
        List<String> donator = donaterGroups.get(group);
        
        if (servers == null || servers.size() == 0 & donator == null || servers.size() == 0){
            return sendMsg(sender, ChatColor.RED + "No such game type or server group exists. " + ChatColor.GRAY + "Try one of these: " + ChatColor.BLUE + "hub, dodgeball, gortume");
        }if (args.length == 1) {
        	 if(donator == null){
            	 server = servers.get(rand.nextInt(servers.size()));
             }else{
             	if(player.hasPermission("themass.donator")){
             		server = donator.get(rand.nextInt(donator.size()));
             	}else{
             		plugin.sendPermissions(player);
             	}
             }    
        } else { // A server ID has been specified
            int id = -1;
            try {
                id = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) { }
            if (id < 1 || id > servers.size())
                return sendMsg(sender, ChatColor.RED + "Invalid ID: " + (servers.size() == 1 ? "there is only one " +
                        group + " server." : "must be between 1 and " + servers.size() + ", inclusive."));
            server = servers.get(id - 1);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        try {
          out.writeUTF("Connect");
          out.writeUTF(server);
        }
        catch (IOException e) {
            plugin.getLogger().severe("Could not redirect player " + player.getName() + " to server " +
                    server + ".");
            e.printStackTrace();
        }
        try {
            player.sendPluginMessage(plugin, "BungeeCord", baos.toByteArray());
            if (plugin.getConfig().getBoolean("messages.server-change.display"))
                plugin.getServer().broadcastMessage(TheMass.PREFIX + plugin.getConfig().getString("messages.server-change.message")
                        .replaceAll("%player%", player.getName()).replaceAll("%group%", group));
            return true;
        } catch (ChannelNotRegisteredException e) {
            return sendMsg(sender, ChatColor.RED + "This server is not on a BungeeCord setup.");
        }
    }
}
