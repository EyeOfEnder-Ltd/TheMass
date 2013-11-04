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
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.eyeofender.themass.TheMass;

public class HatMenu implements Listener {

	public static Inventory i;
	
	@SuppressWarnings("unused")
	private TheMass plugin;
	
	public HatMenu (TheMass plugin){
		this.plugin = plugin;
	}
	
	
	/***********************************************************
	 * 
	 * 				Inventorys
	 * 
	 **************************************************************/

	
	public void createMenu(Player player){
		i = Bukkit.getServer().createInventory(null, 9, "Hat Menu");
		
         i.setItem(0, owners());
         
         i.setItem(2, developers());

         i.setItem(4, admins());

         i.setItem(6, moderators());

         i.setItem(8, youtubers());

         player.openInventory(i);
	}
	
	public void createOwners(Player player){
		i = Bukkit.getServer().createInventory(null, 9, "Owner Hat Menu");
		
         i.setItem(2, gizzy());
         
         i.setItem(4, rafi());

         i.setItem(6, enayet());

         player.openInventory(i);
	}
	
	public void createDevelopers(Player player){
		i = Bukkit.getServer().createInventory(null, 9, "Developer Hat Menu");
		
         i.setItem(2, avery());
         
         i.setItem(6, maxim());

         player.openInventory(i);
	}
	
	public void createAdmins(Player player){
		i = Bukkit.getServer().createInventory(null, 9, "Developer Hat Menu");
		
         i.setItem(0, TheArcadix());
         
         i.setItem(2, DemandedLogic());
         
         i.setItem(4, OverlordKiller());

         i.setItem(6, ExoticGhost());

         i.setItem(8, ExportB());

         player.openInventory(i);
	}
	
	public void createModerators(Player player){
		i = Bukkit.getServer().createInventory(null, 27, "Moderator Hat Menu");
		
         i.setItem(0, MrMouldyMango());
         
         i.setItem(2, CheezyMarsBar14());
         
         i.setItem(4, Bio_HaZard24());

         i.setItem(6, rete25iscool());

         i.setItem(8, RetroSpectrum());
         
         i.setItem(10, Queen_Cerii());

         i.setItem(12, ThatPuppy());

         i.setItem(14, Keith1411());

         i.setItem(16, TheSpedKid());

         i.setItem(18, ET_xXx());

         i.setItem(20, xanderman2113());
         
         i.setItem(22, Open());

         i.setItem(24, Open());

         i.setItem(26, Open());

         
         player.openInventory(i);
	}
	
	public void createYoutube(Player player){
		i = Bukkit.getServer().createInventory(null, 27, "Youtube Hat Menu");
		
         i.setItem(0, SkythekidRS());
         
         i.setItem(2, AntVenom());
         
         i.setItem(4, CavemanFilms());

         i.setItem(6, HuskyMudkipper());

         i.setItem(8, deadlox());
         
         i.setItem(10, MunchingBrotato());

         i.setItem(12, ASFJerome());

         i.setItem(14, BajanCanadian());

         i.setItem(16, HwnT());

         i.setItem(18, TrueMU());

         i.setItem(20, Bashurverse());

         i.setItem(22, ChimneySwift());

         i.setItem(24, SSundee());

         i.setItem(26, Bodil40());
         
         player.openInventory(i);
	}
	
	/***********************************************************
	 * 
	 * 				Sections
	 * 
	 **************************************************************/
	
	public ItemStack hatMenu() {
		ItemStack is = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Able to change hats.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Hat Menu");
		is.setItemMeta(im);
		return is;
	}	
	
	public ItemStack owners() {
		ItemStack is = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click for server owners heads.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Server Owners");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack developers() {
		ItemStack is = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click for server developers heads.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Server Developers");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack admins() {
		ItemStack is = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click for server admins heads.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Server Admin");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack moderators() {
		ItemStack is = new ItemStack(Material.IRON_BLOCK);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click for server moderators heads.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Server Moderators");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack youtubers() {
		ItemStack is = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Click for youtubers heads.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Youtubers");
		is.setItemMeta(im);
		return is;
	}
	
	/*****************************************************************************************
	 * 
	 * 
	 * 
	 *********************************************************************************************/
	
	public ItemStack gizzy() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Server Owner.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "gizzy14gazza");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack rafi() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Server Owner.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "shazz96");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack enayet() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Server Owner.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "enayet123");
		is.setItemMeta(im);
		return is;
	}
	
	/**************************************************************************
	 * 
	 * 						Developers
	 * 
	 *************************************************************************/
	
	public ItemStack avery() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Server Developer.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "avery246813579");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack maxim() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Website Developer.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "c4d3r");
		is.setItemMeta(im);
		return is;
	}
	
	/**************************************************************************
	 * 
	 * 						Admins
	 * 
	 *************************************************************************/
	
	public ItemStack TheArcadix() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Head Admin.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "TheArcadix");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack DemandedLogic() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Admin.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "DemandedLogic");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack OverlordKiller() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Admin.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "OverlordKiller");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ExoticGhost() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Admin.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ExoticGhost");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ExportB() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Admin.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ExportB");
		is.setItemMeta(im);
		return is;
	}
	
	/**************************************************************************
	 * 
	 * 						Moderators
	 * 
	 *************************************************************************/
	
	public ItemStack MrMouldyMango() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "MrMouldyMango");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack CheezyMarsBar14() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "CheezyMarsBar14");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Bio_HaZard24() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Bio_HaZard24");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack rete25iscool() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "rete25iscool");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack RetroSpectrum() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "RetroSpectrum");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Queen_Cerii() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Queen_Cerii");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ThatPuppy() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ThatPuppy");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Keith1411() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Keith1411");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack TheSpedKid() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "TheSpedKid");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ET_xXx() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ET_xXx");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack xanderman2113() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Moderator.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "xanderman2113");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack SkythekidRS() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "SkythekidRS");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack AntVenom() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "AntVenom");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack CavemanFilms() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "CavemanFilms");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack HuskyMudkipper() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "HuskyMudkipper");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack deadlox() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "deadlox");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack MunchingBrotato() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "MunchingBrotato");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ASFJerome() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ASFJerome");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack BajanCanadian() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "BajanCanadian");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack HwnT() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "HwnT");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack TrueMU() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "TrueMU");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Bashurverse() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Bashurverse");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack ChimneySwift() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "ChimneySwift");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack SSundee() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "SSundee");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Bodil40() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Youtuber.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Bodil40");
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack Open() {
		ItemStack is = new ItemStack(Material.SKULL_ITEM);
		ItemMeta im = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Could be you.");
		im.setLore(lore);
		im.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Open Position");
		is.setItemMeta(im);
		return is;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		
		if(event.getAction() == null || event.getItem() == null){
			return;
		}
		
		if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR ||event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(event.getItem().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Hat Menu")){
				
				this.createMenu(event.getPlayer());
				event.setCancelled(true);
			
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player)) return;
		
		Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        
        /************************************************
         * 
         *         Sections
         * 
         ***********************************************/

        if (clicked == null || clicked.getType() == Material.AIR) return;

        
        
	  	  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Hat Menu")) {
			  	event.setCancelled(true);
			  	this.createMenu(player);
				return;
		  } 
  	  
        
        if(event.getInventory().equals(i) || event.getInventory().equals(player.getInventory())){
        
        if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Server Owners")) {
        	event.setCancelled(true);
        	this.createOwners(player);
        	return;
        }
        
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Server Developers")) {
			  	event.setCancelled(true);
			  	this.createDevelopers(player);
				return;
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Server Admin")) {
			  	event.setCancelled(true);
			  	this.createAdmins(player);
				return;
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Server Moderators")) {
			  	event.setCancelled(true);
			  	this.createModerators(player);
				return;
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Youtubers")) {
			  	event.setCancelled(true);
			  	this.createYoutube(player);
				return;
		  }
        
        /************************************************
         * 
         *         People
         * 
         ***********************************************/
		
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "gizzy14gazza")) {
				event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("gizzy14gazza");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "shazz96")) {
			  	event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("shazz96");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "enayet123")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("enayet123");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "avery246813579")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("avery246813579");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "c4d3r")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("c4d3r");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "TheArcadix")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("TheArcadix");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "DemandedLogic")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("DemandedLogic");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "OverlordKiller")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("OverlordKiller");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ExoticGhost")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ExoticGhost");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ExportB")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ExportB");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "MrMouldyMango")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("MrMouldyMango");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "CheezyMarsBar14")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("CheezyMarsBar14");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Bio_HaZard24")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Bio_HaZard24");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  } 
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "rete25iscool")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("rete25iscool");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "RetroSpectrum")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("RetroSpectrum");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Queen_Cerii")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Queen_Cerii");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ThatPuppy")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ThatPuppy");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Keith1411")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Keith1411");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "TheSpedKid")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("TheSpedKid");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ET_xXx")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ET_xXx");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "SkythekidRS")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("SkythekidRS");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "AntVenom")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("AntVenom");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "CavemanFilms")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("CavemanFilms");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "HuskyMudkipper")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("HuskyMudkipper");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "deadlox")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("deadlox");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "MunchingBrotato")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("MunchingBrotato");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ASFJerome")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ASFJerome");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "BajanCanadian")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("BajanCanadian");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "HwnT")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("HwnT");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "TrueMU")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("TrueMU");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Bashurverse")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Bashurverse");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "ChimneySwift")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("ChimneySwift");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "SSundee")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("SSundee");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Bodil40")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Bodil40");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "xanderman2113")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("xanderman2113");
				skull.setItemMeta(meta);
				player.getInventory().setHelmet(skull);
				player.closeInventory();
				return;	
		  }
		  
		  if (clicked.getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Open Position")) {
			  event.setCancelled(true);
				ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner("Steve");
				plugin.sendMessage(player, "Moderator position is open. Visit Www.TheMassMc.Com for more info!");
				player.closeInventory();
				return;	
		  }
        }
	}
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent event){
		if(event.getSlotType().equals(SlotType.ARMOR)){
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			player.getInventory().setHelmet(null);
		}
	}
}
