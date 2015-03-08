package me.buildcarter8.NotchCraft;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

import me.buildcarter8.NotchCraft.Commands.CantFindPlayerException;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class NC_Util 
{

	private static final Logger log = Logger.getLogger("Minecraft-Server");
	   
	   public static String implodeStringList(String glue, List<String> pieces)
	   {
	       StringBuilder output = new StringBuilder();
	       for (int i = 0; i < pieces.size(); i++)
	       {
	           if (i != 0)
	           {
	               output.append(glue);
	           }
	           output.append(pieces.get(i));
	       }
	       return output.toString();
	   }
	   public static boolean isUserStaff(CommandSender user) throws CantFindPlayerException
	   {
	   if (!(user instanceof Player))
	   {
	   return true;
	   }
	   if (Bukkit.getOnlineMode())
	   {
	   if (Notchcraft.staff.contains(user.getName().toLowerCase()))
	   {
	   return true;
	   }
	   }
		   return false;
	   }
	   

	   

	      

	   
	       public static void createDefaultConfiguration(String name, Notchcraft NC, File plugin_file)
	    {
	        File actual = new File(NC.getDataFolder(), name);
	        if (!actual.exists())
	        {
	            log.info("[" + NC.getDescription().getName() + "]: Installing default configuration file template: " + actual.getPath());
	            InputStream input = null;
	            try
	            {
	                JarFile file = new JarFile(plugin_file);
	                ZipEntry copy = file.getEntry(name);
	                if (copy == null)
	                {
	                    log.severe("[" + NC.getDescription().getName() + "]: Unable to read default configuration: " + actual.getPath());
	                    return;
	                }
	                input = file.getInputStream(copy);
	            }
	            catch (IOException ioex)
	            {
	                log.severe("[" + NC.getDescription().getName() + "]: Unable to read default configuration: " + actual.getPath());
	            }
	            if (input != null)
	            {
	                FileOutputStream output = null;

	                try
	                {
	                    NC.getDataFolder().mkdirs();
	                    output = new FileOutputStream(actual);
	                    byte[] buf = new byte[8192];
	                    int length = 0;
	                    while ((length = input.read(buf)) > 0)
	                    {
	                        output.write(buf, 0, length);
	                    }

	                    log.info("[" + NC.getDescription().getName() + "]: Default configuration file written: " + actual.getPath());
	                }
	                catch (IOException ioex)
	                {
	                    log.log(Level.SEVERE, "[" + NC.getDescription().getName() + "]: Unable to write default configuration: " + actual.getPath(), ioex);
	                }
	                finally
	                {
	                    try
	                    {
	                        if (input != null)
	                        {
	                            input.close();
	                        }
	                    }
	                    catch (IOException ioex)
	                    {
	                    }

	                    try
	                    {
	                        if (output != null)
	                        {
	                            output.close();
	                        }
	                    }
	                    catch (IOException ioex)
	                    {
	                    }
	                }
	            }
	        }
	    }
public static boolean deleteFolder(File file)
{
 if (file.exists())
 {
     if (file.isDirectory())
     {
         for (File f : file.listFiles())
         {
             if (!NC_Util.deleteFolder(f))
             {
                 return false;
             }
         }
     }
     file.delete();
     return !file.exists();
 }
 else
 {
     return false;
 }
}
}


