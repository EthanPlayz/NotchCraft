package me.buildcarter8.NotchCraft.Commands;

public enum StaffLevel 
{
	 ALL("All Player Commands"), MOD("Mod Commands"), ADMIN("Admin Commands"), Executive("Executive Commands");
	 //
	 private final String friendlyName;
	 private StaffLevel(String friendlyName)
	 {
	 this.friendlyName = friendlyName;
	 }
	 public String getFriendlyName()
	 {
	 return friendlyName;
	 }
}
