package me.buildcarter8.NotchCraft.Commands;

import me.buildcarter8.NotchCraft.NC_Util;
import me.buildcarter8.NotchCraft.Notchcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_staff extends NC_Command
{

	 public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
	    {
		 if (args.length < 2)
		 {
		 return false;
		 }
		 if (args[0].equalsIgnoreCase("add"))
		 {
		 Player p;
		 try
		 {
		 p = getPlayer(args[1]);
		 }
		 catch (CantFindPlayerException ex)
		 {
		 sender.sendMessage(ex.getMessage());
		 return true;
		 }
		 try {
			if(NC_Util.isUserStaff(sender))
			 {

			String user_name = p.getName().toLowerCase().trim();
			 NC_Util.
			 Bukkit.broadcastMessage(ChatColor.AQUA + "[NC Staff] Adding " + user_name);
			 }
		} catch (CantFindPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 } else
			 sender.sendMessage("Nope!");
		return true;

		 
		
		 }
		 {
}
}


