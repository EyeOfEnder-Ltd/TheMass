package com.eyeofender.themass.items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.eyeofender.themass.TheMass;

public class ServerCompass implements Listener {

	public static Inventory i;
	
	@SuppressWarnings("unused")
	private TheMass plugin;
	
	public ServerCompass (TheMass plugin){
		this.plugin = plugin;
	}
	
	public void createCompass(Player player){
		i = Bukkit.getServer().createInventory(null, 9, "Server Selection Tool");
		
         i.setItem(1, dodgeBall());
         
         i.setItem(3, gortume());

         i.setItem(5, jenga());

         i.setItem(7, factions());

         player.openInventory(i);
	}
	
	public ItemStack serverCompass() {
		ItemStack is = new ItemStack(Material.COMPASS);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click to change servers.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Compass");
		is.setItemMeta(im);
		return is;
	}	
	
	public ItemStack dodgeBall() {
		ItemStack is = new ItemStack(Material.SNOW_BALL);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Play Dodgeball.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Dodgeball");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack gortume() {
		ItemStack is = new ItemStack(Material.JACK_O_LANTERN);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Play Gortume.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Gortume");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack jenga() {
		ItemStack is = new ItemStack(Material.BOW);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Coming Soon.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Jenga");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack factions() {
		ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Coming Soon.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Factions");
		is.setItemMeta(im);
		return is;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR ||event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(event.getItem().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Compass")){

				if(event.getAction() == null || event.getItem() == null){
					return;
				}
				
				this.createCompass(event.getPlayer());
				event.setCancelled(true);
			
			}
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(event.getAction() == null || event.getItem() == null){
				return;
			}
			
			if(event.getItem() == this.dodgeBall()){
				event.setCancelled(true);
				player.performCommand("dodgeball");
				return;
			}
			
			if(event.getItem() == this.gortume()){
				event.setCancelled(true);
				player.performCommand("gortume");
				return;
			}
			
			if(event.getItem() == this.jenga()){
				event.setCancelled(true);
				return;
			}
			
			if(event.getItem() == this.factions()){
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

        
        if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Magic Compass")) {
			  	event.setCancelled(true);
			  	this.createCompass(player);
				return;
		  } 
		
        if(event.getInventory().equals(i)){
        
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Dodgeball")) {
				event.setCancelled(true);
				player.performCommand("dodgeball");
				return;
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Gortume")) {
			  	event.setCancelled(true);
				player.performCommand("gortume");
				return;
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Jenga")) {
			  	event.setCancelled(true);
				return;
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Factions")) {
			  	event.setCancelled(true);
				return;
		  } 
		  
		  
        }
	}
}
