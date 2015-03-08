package me.buildcarter8.NotchCraft.Commands;

import java.util.List;
import java.util.logging.Logger;



import me.buildcarter8.NotchCraft.Notchcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
public class NC_Command
{

	protected Notchcraft plugin;
    protected static final Logger log = Logger.getLogger("Minecraft-Server");
    
    public NC_Command()
    {
    }
    
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        log.severe("Command Error: Command not implemented: " + cmd.getName());
        sender.sendMessage(ChatColor.RED + "Command Error: Command not implemented: " + cmd.getName());
        return false;
    }
    
    public void setPlugin(Notchcraft plugin)
    {
        this.plugin = plugin;
    }
    
    public Player getPlayer(String partialname) throws CantFindPlayerException
    {
        List<Player> matches = Bukkit.matchPlayer(partialname);
        if (matches.isEmpty())
        {
            throw new CantFindPlayerException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }
}

