package dev.himirai.sampleplugin;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class SamplePlugin extends JavaPlugin implements Listener {

	@Getter
	private static SamplePlugin plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void on(AsyncPlayerPreLoginEvent event) {
		getLogger().log(Level.INFO, "Player " + event.getPlayerProfile().getName() + " pre-logging in...");
	}

	@EventHandler
	public void on(PlayerJoinEvent event) {
		event.joinMessage(null);
		getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " connected!");
	}

	@EventHandler
	public void on(PlayerQuitEvent event) {
		event.quitMessage(null);
		getLogger().log(Level.INFO, "Player " + event.getPlayer().getName() + " disconnected");
	}

}
