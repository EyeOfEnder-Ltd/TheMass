package com.eyeofender.themass.listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

import com.eyeofender.themass.TheMass;
import com.eyeofender.themass.items.HatMenu;
import com.eyeofender.themass.items.ServerCompass;
import com.eyeofender.themass.items.VanishClock;

public class PlayerListener implements Listener{
 
	private TheMass plugin;
	 
   // private VanishClock clock = new VanishClock(plugin);
   // private ServerCompass compass = new ServerCompass(plugin);
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
			
	        if(l != null){
	        	event.getPlayer().teleport(l.clone().add(0.5D, 0.5D, 0.5D));
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
	    
	    @EventHandler
	    public void onInteract(PlayerInteractEvent event) {
	    	if(event.getAction() == Action.PHYSICAL) {
	    	//The player triggered a physical interaction event
	    	 
	    	if(event.getClickedBlock().getType() == Material.STONE_PLATE) {
	    	//The player stepped on a stone pressure plate
	    	 
	    		event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(5));
	            event.getPlayer().setVelocity(new Vector(event.getPlayer().getVelocity().getX(), 1.0D, event.getPlayer().getVelocity().getZ()));
	    	}
	        }
	    }
	    
	    @EventHandler
	    public void onPlayerDamage(EntityDamageEvent e) {
	        if (e.getEntity() instanceof Player) {
	            Player p = (Player) e.getEntity();
	            if (e.getCause() == DamageCause.FALL) {
	                e.setDamage(0.0);
	            }
	        }
	    }
	    
}
