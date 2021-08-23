package com.jroo3;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	//ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	//String command = "time set day";
	//Bukkit.dispatchCommand(console, command);
	
	
	
	
	public static ArrayList<Player> players = new ArrayList<Player>();

	public void onEnable() {
		

		this.getServer().getPluginManager().registerEvents(this, this);
		new Commands(this);
		new Commandst(this);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity ent = e.getEntity();
		if (!(ent.getType().equals(EntityType.PLAYER))) {
			return;
		}
		Player p = (Player) ent;
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	
	
	@EventHandler
	public void onEntityDeath(EntityDamageByEntityEvent e) {
		Entity ent = e.getDamager();
		if (!(ent.getType().equals(EntityType.PLAYER))) {
			return;
		}
	
		Player p = (Player) ent;
		
		
		if (players.contains(p)) {
			ItemStack i = new ItemStack(randomMat());
			Inventory inv = p.getInventory();
			if (p.getInventory().firstEmpty() == -1) {
				World w = p.getWorld();
				Location l = p.getLocation();
				w.dropItem(l, i);
			}
			inv.addItem(i);
		}
	}
	
	
	
	
	
	public static String[] names() {
	    return Stream.of(Material.values()).map(Material::name).toArray(String[]::new);
	}
	
	private Material randomMat() {
	    int pick = new Random().nextInt(Material.values().length);
	    if (!Material.values()[pick].equals(Material.AIR)) {
	    return Material.values()[pick];
	    } else {
	    	return Material.SPONGE;
	    }
	}
	

}
