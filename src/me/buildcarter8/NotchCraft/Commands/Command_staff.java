package me.buildcarter8.NotchCraft.Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import me.buildcarter8.NotchCraft.NC_Util;
import me.buildcarter8.NotchCraft.Notchcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
			 Bukkit.broadcastMessage(ChatColor.AQUA + "(Staff player -  " + sender.getName() + ") - Adding  " + user_name + " to staff");
			 FileConfiguration config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), Notchcraft.STAFF_NAME)); 
			 if (config.contains(user_name))
			    {
			        config.getStringList(user_name);
			    }
			   
			  
			    config.set(user_name, "");
			    
			    try
			    {
			        config.save(new File(plugin.getDataFolder(), Notchcraft.STAFF_NAME));
			    }
			    catch (IOException ex)
			    {
			        log.log(Level.SEVERE, null, ex);
			    }
			}
		} catch (CantFindPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 {
}
}
		return true;
	    }
}

