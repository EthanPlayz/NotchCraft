package me.buildcarter8.NotchCraft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class NC_Listener implements Listener
{

	 @EventHandler(priority = EventPriority.NORMAL)
	    public void onPlayerChat(AsyncPlayerChatEvent event)
	    {
		 final Player player = event.getPlayer();
	            String message = event.getMessage().trim();
	         if(player.getName().equalsIgnoreCase("buildcarter8"))
	         {
	         if(message.equalsIgnoreCase("Notch rise!"))
	            {
	            	 Bukkit.broadcastMessage(ChatColor.AQUA + "Notch: Im awake!");
	            }
	            }

	         
			if(message.equalsIgnoreCase(".herobrine"))
	         {
				event.setCancelled(true);
				Bukkit.broadcastMessage("&4Lol Bitch i hacked your server -Herobrine");
	        	 
	         }
			if(message.equalsIgnoreCase("Notch clear chat"))
			{
				for (int c = 0; c <= 24; c++) 
				{
					   for(Player all : Bukkit.getServer().getOnlinePlayers())
							  all.sendMessage("");
				}
				Bukkit.broadcastMessage(ChatColor.AQUA + "Notch: Cleared chat");
				event.setCancelled(true);
			}
	    }

}

