package com.eyeofender.themass;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import com.eyeofender.themass.commands.CommandTheMass;
import com.eyeofender.themass.commands.CommandPlay;
import com.eyeofender.themass.items.HatMenu;
import com.eyeofender.themass.items.ServerCompass;
import com.eyeofender.themass.items.VanishClock;
import com.eyeofender.themass.listener.EnvironmentListener;
import com.eyeofender.themass.listener.PlayerListener;

public class TheMass extends JavaPlugin {

    public static final String PREFIX = ChatColor.GOLD + "[" + ChatColor.AQUA + ChatColor.BOLD + "T" + ChatColor.AQUA +"he" + ChatColor.AQUA + ChatColor.BOLD + "M" + ChatColor.AQUA + "ass" + ChatColor.GOLD + "] " + ChatColor.GRAY;
    public static final String permissions = "" + ChatColor.AQUA + ChatColor.BOLD + "Access denied." + ChatColor.DARK_RED + " Try again later!";
    
    private CommandPlay cp;
    
    private Map<String, Boolean> vanished = new HashMap<String, Boolean>();
    
    //private VanishClock clock = new VanishClock(this);
  //  private ServerCompass compass = new ServerCompass(this);
    private HatMenu hat = new HatMenu(this);
    
    @Override
    public void onEnable() {
        getLogger().info("Loading: config.yml");
        
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        
        if (getConfig().getBoolean("proxy-enabled")) {
            getLogger().info("Loading: BungeeCord connection");
            getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        } else {
            getLogger().warning("Communication with the BungeeCord proxy is disabled in the config. Players will " +
                    "not be able to move between servers with the '/play <server group>' command.");
        }
        getLogger().info("Loading: command handlers");
        getCommand("cloudcontrol").setExecutor(new CommandTheMass(this));
        cp = new CommandPlay(this);
        getCommand("play").setExecutor(cp);
        getLogger().info("Loading: listeners");
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getServer().getPluginManager().registerEvents(new EnvironmentListener(this), this);
  //      getServer().getPluginManager().registerEvents(new VanishClock(this), this);
   //     getServer().getPluginManager().registerEvents(new ServerCompass(this), this);
      //  getServer().getPluginManager().registerEvents(new HatMenu(this), this);
        
    }

    @Override
    public void onDisable() {
        saveConfig();
        HandlerList.unregisterAll(this);
        
        for(Player player : this.getServer().getOnlinePlayers()){
        	player.performCommand("spawn");
        }
    }

    public void reloadServerGroups() {
        cp.loadServerGroups();
    }
    
    public void sendMessage(Player player, String message){
    	player.sendMessage(PREFIX + message); 
    }
    
    public void sendPermissions(Player player){
    	player.sendMessage(permissions);
    }
    
    public void sendArgs(Player player){
    	this.sendMessage(player, ChatColor.DARK_RED + "Incorrect amount of arguments.");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
    	
    	Player player = (Player) sender;
    	
    	if(CommandLabel.equalsIgnoreCase("hub")){
    		player.performCommand("play hub");
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("gortume")){
    		player.performCommand("play gortume");
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("dodgeball")){
    		player.performCommand("play dodgeball");
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("vanish")){
    		if(player.hasPermission("themass.vanish")){
    			if(args.length == 0){
    				if(vanished.containsKey(player.getName())){

    					for(Player players : this.getServer().getOnlinePlayers()){
    						players.showPlayer(player);
    					}
    					
    					this.sendMessage(player, "You are now visible.");
    					vanished.remove(player.getName());
    				}else{
    					for(Player players : this.getServer().getOnlinePlayers()){
    						players.hidePlayer(player);
    					}
    					
    					this.sendMessage(player, "You have been vanished.");
    					vanished.put(player.getName(), true);
    				}
    			}else if(args.length == 1){
    				Player tp = this.getServer().getPlayer(args[0]);
    				
    				if(tp != null){
        				if(vanished.containsKey(tp.getName())){
        					for(Player players : this.getServer().getOnlinePlayers()){
        						players.showPlayer(tp);
        					}
        					
        					this.sendMessage(tp, "You are now visible.");
        					this.sendMessage(player, "You have made " + ChatColor.BLUE + tp.getName() + ChatColor.GRAY + " visible.");
        					vanished.remove(player.getName());
        				}else{
        					for(Player players : this.getServer().getOnlinePlayers()){
        						players.hidePlayer(tp);
        					}
        					
        					this.sendMessage(tp, "You have been vanished.");
        					this.sendMessage(player, "You have vanished " + ChatColor.BLUE + tp.getName() + ChatColor.GRAY + ".");
        					vanished.put(tp.getName(), true);
        				}
    				}else{
    					this.sendMessage(player, "Target player is not online!");
    				}
    			}else{
    				sendArgs(player);
    			}
    		}else{
				this.sendPermissions(player);
			}
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("Spawn")){
    		if(player.hasPermission("themass.spawn")){
    			World world = this.getServer().getWorld(this.getConfig().getConfigurationSection("spawn").getString("world"));
    			
    			String y = this.getConfig().getConfigurationSection("spawn").getString("yaw");
    			String p = this.getConfig().getConfigurationSection("spawn").getString("pitch");
    			
    			float yaw = 0;
    			float pitch = 0;
    			
    			try{
    				yaw = (Float)Float.parseFloat(y);
    				pitch = (Float)Float.parseFloat(p);
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    			Location l = new Location(world, this.getConfig().getConfigurationSection("spawn").getInt("x"), this.getConfig().getConfigurationSection("spawn").getInt("y"),this.getConfig().getConfigurationSection("spawn").getInt("z"), yaw, pitch);
    			player.teleport(l.clone().add(0.5D, 0.5D, 0.5D));
    			this.sendMessage(player, "Spawned to server spawn.");
    			
    			if(this.getConfig().getBoolean("itemsOnJoin")){
	    			
	    			/** Clears players Inventory **/
	    			player.getInventory().clear();
	    			
	    			/** Adds starting items **/
	    			
	    	//		player.getInventory().addItem(this.clock.vanishClock());
	    		//	player.getInventory().addItem(compass.serverCompass());
	    		//	player.getInventory().addItem(hat.hatMenu());
    			}
    		}else{
    			this.sendPermissions(player);
    		}
    		
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("Setspawnpoint")){
    		if(player.hasPermission("themass.setspawn")){
    			if(this.getConfig().contains("spawn")){
    				this.getConfig().getConfigurationSection("spawn").set("x", player.getLocation().getBlockX());
    				this.getConfig().getConfigurationSection("spawn").set("y", player.getLocation().getBlockY());
    				this.getConfig().getConfigurationSection("spawn").set("z", player.getLocation().getBlockZ());
    				this.getConfig().getConfigurationSection("spawn").set("yaw", player.getLocation().getYaw());
    				this.getConfig().getConfigurationSection("spawn").set("pitch", player.getLocation().getPitch());
    				this.getConfig().getConfigurationSection("spawn").set("world", player.getLocation().getWorld().getName());
    			}else{
    				this.getConfig().createSection("spawn");
    				this.getConfig().getConfigurationSection("spawn").set("x", player.getLocation().getBlockX());
    				this.getConfig().getConfigurationSection("spawn").set("y", player.getLocation().getBlockY());
    				this.getConfig().getConfigurationSection("spawn").set("z", player.getLocation().getBlockZ());
    				this.getConfig().getConfigurationSection("spawn").set("yaw", player.getLocation().getYaw());
    				this.getConfig().getConfigurationSection("spawn").set("pitch", player.getLocation().getPitch());
    				this.getConfig().getConfigurationSection("spawn").set("world", player.getLocation().getWorld().getName());
    			}
    			
    			this.sendMessage(player, "Spawn has been set.");
    		}else{
    			this.sendPermissions(player);
    		}
    	}
    	
    	if(CommandLabel.equalsIgnoreCase("open")){
    		if(player.hasPermission("themass.open")){
    			if(args.length == 0){
    				this.sendMessage(player, "Usage: /Open <Player>");
    			}else if(args.length == 1){
    				Player tp = this.getServer().getPlayer(args[0]);
    				
    				if(tp != null){
    					player.openInventory(tp.getInventory());
    					this.sendMessage(player, "You have opened " + ChatColor.BLUE + tp.getName() + "'s " + ChatColor.GRAY + "inventory.");
    				}else{
    					this.sendMessage(player, ChatColor.DARK_RED + "Player not found.");
    				}
    			}
    		}else{
    			this.sendPermissions(player);
    		}
    	}
    	
		return false;
    
    }
}
