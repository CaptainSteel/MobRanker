package me.CaptainSteel.MobRanker;

import java.util.logging.Logger;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin implements Listener
{
	Logger l = Logger.getLogger("MobRanker");
	
	private FileConfiguration config = this.getConfig();
	
	public void onEnable()
	{
		l.info("=======================");
		l.info("     MobRanker");
		l.info("       1.0");
		l.info("     Captain_Steel");
		l.info("=======================");
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		 
		this.saveDefaultConfig();
		
	}
	
	public void onDisable()
	{
		l.info("=======================");
		l.info("     MobRanker");
		l.info("       1.0");
		l.info("     Captain_Steel");
		l.info("=======================");
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e)
	{
		if(e.getEntity() instanceof Monster)
		{
			Monster monster = (Monster) e.getEntity();
			Player player = monster.getKiller();
			
			PermissionUser user = PermissionsEx.getUser(player);
			
			int current = config.getInt("Players." + player.getUniqueId() + ".kills");
					
			if(player != null)
			{
				int before = config.getInt("Players." + player.getUniqueId() + ".kills");
				int after = before + 1;
				config.set("Players." + player.getUniqueId() + ".kills", after);
				this.saveConfig();
				this.reloadConfig();
				
				player.sendMessage(ChatColor.GOLD + "You have killed these many mobs: " + ChatColor.RED + current);
				
				if(current == config.getInt("Ranks.1.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.1.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.1.rankName"));
					return;
				}else if(current == config.getInt("Ranks.2.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.2.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.2.rankName"));
					return;
				}else if(current == config.getInt("Ranks.3.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.3.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.3.rankName"));
					return;
				}else if(current == config.getInt("Ranks.4.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.4.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.4.rankName"));
					return;
				}else if(current == config.getInt("Ranks.5.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.5.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.5.rankName"));
					return;
				}else if(current == config.getInt("Ranks.6.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.6.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.6.rankName"));
					return;
				}else if(current == config.getInt("Ranks.7.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.7.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.7.rankName"));
					return;
				}else if(current == config.getInt("Ranks.8.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.8.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.8.rankName"));
					return;
				}else if(current == config.getInt("Ranks.9.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.9.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.9.rankName"));
					return;
				}else if(current == config.getInt("Ranks.10.killsNeeded"))
				{
					user.addGroup(config.getString("Ranks.10.rankName"));
					player.sendMessage(ChatColor.GOLD + "You have ranked up to: " + ChatColor.RED + config.getString("Ranks.10.rankName"));
					return;
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();
		
		if(config.get("Players." + player.getUniqueId() + "kills") == null)
		{
			config.set("Players." + player.getUniqueId() + ".kills", 0);
			saveConfig();
			this.reloadConfig();
			player.sendMessage(ChatColor.GOLD + "We have loaded you :");
		}else
		{
			int current = config.getInt("Players." + player.getUniqueId() + ".kills");
		
			player.sendMessage(ChatColor.GOLD + "You have killed these many mobs: " + ChatColor.RED + current);
		}
	}
}
	
