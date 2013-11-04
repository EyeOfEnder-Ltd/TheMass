package com.eyeofender.themass.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.eyeofender.themass.TheMass;

public class VanishClock implements Listener{

	private TheMass plugin;
	
	private Map<String, Boolean> vanished = new HashMap<String, Boolean>(); 
	
	public VanishClock (TheMass plugin){
		this.plugin = plugin;
	}
	
	public ItemStack vanishClock() {
		ItemStack is = new ItemStack(Material.WATCH);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Toggles player visibility in game.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Clock");
		is.setItemMeta(im);
		return is;
	}
	
	public void vanish(Player player){
		if(!vanished.containsKey(player.getName())){
			for(Player players : plugin.getServer().getOnlinePlayers()){
				player.getPlayer().hidePlayer(players);
				vanished.put(player.getName(), true);
				
			}
			plugin.sendMessage(player, "All players have been vanished.");

		}else{
			for(Player players : plugin.getServer().getOnlinePlayers()){
				player.getPlayer().showPlayer(players);
				vanished.remove(player.getName());
				
			}
			plugin.sendMessage(player, "All players have re-appeared.");

		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(event.getAction() == null || event.getItem() == null){
				return;
			}
			
			if(event.getItem().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Clock")){
				
				this.vanish(event.getPlayer());
				event.setCancelled(true);
				return;
				
			}		
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player)) return;
		
		Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
                
        if (clicked == null || clicked.getType() == Material.AIR) return;
        
	        if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Clock")) {
			  	event.setCancelled(true);
			  		this.vanish(player);
			  	return;
	        }else{
	        	return;
	        }
        }
}
