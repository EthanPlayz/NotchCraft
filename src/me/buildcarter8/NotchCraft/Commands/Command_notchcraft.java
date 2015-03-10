package me.buildcarter8.NotchCraft.Commands;

import me.buildcarter8.NotchCraft.Notchcraft;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@CommandPermissions(level = StaffLevel.ALL)
public class Command_notchcraft extends NC_Command
{
	public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
		sender.sendMessage(ChatColor.AQUA + "======================================");
		sender.sendMessage(ChatColor.GREEN + "NotchCraft plugin vs 1.0, coded by buildcarter8(dev/owner) and EthanPvPYT(Mod/DEV) " + Notchcraft.VERSION);
		sender.sendMessage(ChatColor.AQUA + "======================================");
		
		
		return true;
		
    }
}
