package com.jroo3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	
	public Commands(Main plugin) {
		
	      plugin.getCommand("newitem").setExecutor(this);
	      
	   }

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

		
		
		
		if (arg0 instanceof Player) {
			Player p = (Player) arg0;
			if (Main.players.contains(p)) {
				p.sendMessage("Disabled!");
				Main.players.remove(Main.players.indexOf(p));
			} else {
				Main.players.add(p);
				p.sendMessage("Enabled!");
			}
			
					}
		
		
		
		return false;
	}
}
