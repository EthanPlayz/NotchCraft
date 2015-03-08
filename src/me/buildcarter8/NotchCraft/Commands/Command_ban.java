
public class Command_ban extends NC_Command
{

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
                if (cmd.getName().equalsIgnoreCase("kick")) {
                        if (args.length == 0) {
                                sender.sendMessage(ChatColor.RED + "Please specify a player!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                                return true;
                        }
                        target.kickPlayer(ChatColor.RED + "Your username has been kicked from the server for breaking the rules!");
                        Bukkit.getServer().getPluginManager().callEvent(new EnforcerEvent(target, Type.KICK));
                        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Player " + target.getName() + " has been kicked from the server for breaking the rules by " + sender.getName() + "!");
                }
                if (cmd.getName().equalsIgnoreCase("ban")) {
                        if (args.length == 0) {
                                sender.sendMessage(ChatColor.RED + "Please specify a player!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                                return true;
                        }
                        target.kickPlayer(ChatColor.RED + "You have been perm-banned from the server for breaking MAJOR rules!");
                        target.setBanned(true);
                        Bukkit.getServer().getPluginManager().callEvent(new EnforcerEvent(target, Type.BAN));
                        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Player " + target.getName() + " has been banned from the server for breaking the rules by " + sender.getName() + "!");
                }
                return true;
        }
}