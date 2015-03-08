package me.buildcarter8.NotchCraft;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



import me.buildcarter8.NotchCraft.Commands.NC_Command;
import me.buildcarter8.NotchCraft.listeners.NC_Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
/*
* Copyright (c) 2011-2015, Steven Lawson
* Copyright (c) 2012-2015, Jerom van der Sar
*
* Licensed under the TotalFreedom General License (TFGL) Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://github.com/TotalFreedom/License/blob/master/LICENSE.md
*/
public class Notchcraft extends JavaPlugin
{
	public final Logger log = Bukkit.getLogger();
	 public String PLUGIN_NAME = "NotchCraft";
	 public static String STAFF_NAME = "StaffList.yml";
	 public static String VERSION = "v1.0";
	 public String COMMAND_PATH = "me.buildcarter8.NotchCraft.Commands";
	 public String COMMAND_PREFIX = "Command_";
	 
	  @Override
	 public void onEnable()
	  {
		  log.info("[NC]: Enabled  " + VERSION + " By buildcarter8");
		  NC_Util.deleteFolder(new File("./_deleteme"));
		  loadStaffList();
	  }
	  @Override
	  public void onDisable()
	  {
		  log.info("[NC]: Disabled NotchCraft by buildcarter8");
	  }
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	      try
	      {
	          Player sender_p = null;
	          boolean senderIsConsole = false;
	          if (sender instanceof Player)
	          {
	              sender_p = (Player) sender;
	              log.info(String.format("[PLAYER_COMMAND] %s(%s): /%s %s",
	                      sender_p.getName(),
	                      ChatColor.stripColor(sender_p.getDisplayName()),
	                      commandLabel,
	                      NC_Util.implodeStringList(" ", Arrays.asList(args))));
	          }
	          else
	          {
	              senderIsConsole = true;
	              log.info(String.format("[CONSOLE_COMMAND] %s: /%s %s",
	                      sender.getName(),
	                      commandLabel,
	                      NC_Util.implodeStringList(" ", Arrays.asList(args))));
	          }

	          NC_Command dispatcher;
	          try
	          {
	              ClassLoader classLoader = Notchcraft.class.getClassLoader();
	              dispatcher = (NC_Command) classLoader.loadClass(String.format("%s.%s%s", COMMAND_PATH, COMMAND_PREFIX, cmd.getName().toLowerCase())).newInstance();
	              dispatcher.setPlugin(this);
	          }
	          catch (Throwable ex)
	          {
	              log.log(Level.SEVERE, "[" + getDescription().getName() + "] Command not loaded: " + cmd.getName(), ex);
	              sender.sendMessage(ChatColor.RED + "Command Error: Command not loaded: " + cmd.getName());
	              return true;
	          }

	          try
	          {
	              return dispatcher.run(sender, sender_p, cmd, commandLabel, args, senderIsConsole);
	          }
	          catch (Throwable ex)
	          {
	              sender.sendMessage(ChatColor.RED + "Command Error: " + ex.getMessage());
	          }

	          dispatcher = null;
	      }
	      catch (Throwable ex)
	      {
	          log.log(Level.SEVERE, "[" + getDescription().getName() + "] Command Error: " + commandLabel, ex);
	          sender.sendMessage(ChatColor.RED + "Unknown Command Error.");
	      }

	      return true;
	  }

	  public void loadMainConfig()
	  {

	  }

      public static List<String> staff = new ArrayList<String>();
	  public void loadStaffList()
	  {
		  NC_Util.createDefaultConfiguration(STAFF_NAME, this, getFile());
		  FileConfiguration config = YamlConfiguration.loadConfiguration(new File(getDataFolder(), STAFF_NAME));
          staff = new ArrayList<String>();
          for (String user : config.getKeys(false))
          {
          staff.add(user.toLowerCase().trim());
	  }
	}
}


