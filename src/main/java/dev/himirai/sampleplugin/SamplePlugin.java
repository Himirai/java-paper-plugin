package dev.himirai.sampleplugin;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.util.logging.Level;

public class SamplePlugin extends JavaPlugin implements Listener
{

	@Getter
	private static SamplePlugin plugin;

	public SamplePlugin()
	{
		super();
	}

	public SamplePlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file)
	{
		super(loader, description, dataFolder, file);
	}

	@Override
	public void onEnable()
	{
		plugin = this;
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void on(AsyncPlayerPreLoginEvent event)
	{
		getLogger().log(Level.INFO, "Player " + event.getPlayerProfile().getName() + " pre-logging in...");
	}

	@EventHandler
	public void on(PlayerJoinEvent event)
	{
		getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " connected!");
		event.getPlayer().setLevel(100);
	}

	@EventHandler
	public void on(PlayerQuitEvent event)
	{
		getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " disconnected");
		event.getPlayer().setLevel(0);
	}

}
