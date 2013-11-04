package com.eyeofender.themass.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.eyeofender.themass.TheMass;
import com.eyeofender.themass.items.HatMenu;
import com.eyeofender.themass.items.ServerCompass;
import com.eyeofender.themass.items.VanishClock;

public class PlayerListener implements Listener{
 
	private TheMass plugin;
	 
    private VanishClock clock = new VanishClock(plugin);
    private ServerCompass compass = new ServerCompass(plugin);
    private HatMenu hat = new HatMenu(plugin);

	public PlayerListener (TheMass plugin){
		this.plugin = plugin;
	}
	
	   @EventHandler(priority = EventPriority.HIGHEST)
	    public void onDeath(PlayerDeathEvent event) {
	        event.setDeathMessage(!plugin.getConfig().getBoolean("messages.death.display") ? null :
	            plugin.getConfig().getString("messages.death.message").replaceAll("%player%", event.getEntity().getName()));
	    }

	    @EventHandler(priority = EventPriority.HIGHEST)
	    public void onJoin(PlayerJoinEvent event) {
	    	Player player = event.getPlayer();
	    	
	        event.setJoinMessage(!plugin.getConfig().getBoolean("messages.join-broadcast.display") ? null :
	            plugin.getConfig().getString("messages.join-broadcast.message").replaceAll("%player%", event.getPlayer().getName()));
	        if (plugin.getConfig().getBoolean("messages.join-individual.display"))
	            event.getPlayer().sendMessage(TheMass.PREFIX + plugin.getConfig().getString("messages.join-individual.message")
	                    .replaceAll("%player%", event.getPlayer().getName()));
	        
	        World world = plugin.getServer().getWorld(plugin.getConfig().getConfigurationSection("spawn").getString("world"));
			
			String y = plugin.getConfig().getConfigurationSection("spawn").getString("yaw");
			String p = plugin.getConfig().getConfigurationSection("spawn").getString("pitch");
			
			float yaw = 0;
			float pitch = 0;
			
			try{
				yaw = (Float)Float.parseFloat(y);
				pitch = (Float)Float.parseFloat(p);
			}catch(Exception e){
				e.printStackTrace();
			}
	        
			Location l = new Location(world, plugin.getConfig().getConfigurationSection("spawn").getInt("x"), plugin.getConfig().getConfigurationSection("spawn").getInt("y"),plugin.getConfig().getConfigurationSection("spawn").getInt("z"), yaw, pitch);

			if(plugin.getConfig().getBoolean("itemsOnJoin")){
    			
    			/** Clears players Inventory **/
    			player.getInventory().clear();
    			
    			/** Adds starting items **/
    			
    			////player.getInventory().addItem(this.clock.vanishClock());
    			//player.getInventory().addItem(compass.serverCompass());
    			//player.getInventory().addItem(hat.hatMenu());
			}
			
	        if(l != null){
	        	event.getPlayer().teleport(l);
	        }
	    }

	    @EventHandler(priority = EventPriority.HIGHEST)
	    public void onKick(PlayerKickEvent event) {
	        event.setLeaveMessage(!plugin.getConfig().getBoolean("messages.kicked.display") ? null :
	            plugin.getConfig().getString("messages.kicked.message").replaceAll("%player%",
	            event.getPlayer().getName()).replaceAll("%reason%", event.getReason()));
	    }

	    @EventHandler(priority = EventPriority.HIGHEST)
	    public void onLeave(PlayerQuitEvent event) {
	        event.setQuitMessage(!plugin.getConfig().getBoolean("messages.leave.display") ? null :
	            plugin.getConfig().getString("messages.leave.message").replaceAll("%player%", event.getPlayer().getName()));
	    }
	    
	    @EventHandler(priority = EventPriority.HIGHEST)
		public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
			if (!event.isCancelled()) {
				Player player = event.getPlayer();
				String cmd = event.getMessage().toLowerCase();

				@SuppressWarnings("unused")
				String[] check = cmd.split("");
				if (cmd.contains("/join") && cmd.contains("/j")) {
					player.getInventory().clear();
					player.getInventory().setHelmet(null);
					player.getInventory().setChestplate(null);
					player.getInventory().setLeggings(null);
					player.getInventory().setBoots(null); 
				}
			}
		}
	    
	    @EventHandler
	    public void onPlayerInteract(PlayerInteractEvent e) {
	     
	    if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.SIGN_POST || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.SIGN || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.WALL_SIGN){
	     
	    	Block block = e.getClickedBlock();
	    	Sign sign = (Sign) block.getState();
	     
	    		if(sign.getLine(0).equalsIgnoreCase(""  + ChatColor.GREEN + ChatColor.BOLD + "[Join]")){
	    			String arena = sign.getLine(1);
	    				
	    			Player player = e.getPlayer();
	    			
	    			player.getInventory().clear();
	    			player.getInventory().setHelmet(null);
	    			player.getInventory().setChestplate(null);
	    			player.getInventory().setLeggings(null);
	    			player.getInventory().setBoots(null); 
	    			
	    		}
	    	
	    	}
	    }
	    
	    public void clearInventory(Player player){

	    }
}
