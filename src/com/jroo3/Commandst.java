package com.jroo3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandst implements CommandExecutor {
	public Commandst(Main plugin) {
		
	      plugin.getCommand("tygi").setExecutor(this);
	      
	   }

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

		arg0.sendMessage("When you place blocks, When you break blocks, When you take damage, When you damage a mob, When you eat, and When you craft something.  ");
		
		return false;
	}
}
