package com.lenis0012.bukkit.marriage2.internal;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.lenis0012.bukkit.marriage2.Marriage;
import com.lenis0012.bukkit.marriage2.commands.Command;

public abstract class MarriageBase implements Marriage {
	protected final MarriagePlugin plugin;
	private final MarriageCommandExecutor commandExecutor;
	
	public MarriageBase(MarriagePlugin plugin) {
		this.plugin = plugin;
		this.commandExecutor = new MarriageCommandExecutor(this);
		plugin.getCommand("marry").setExecutor(commandExecutor);
	}
	
	@Override
	public void register(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, plugin);
	}
	
	@Override
	public void register(Class<? extends Command> commandClass) {
		commandExecutor.regster(commandClass);
	}
	
	@Override
	public Logger getLogger() {
		return plugin.getLogger();
	}
	
	@Override
	public MarriagePlugin getPlugin() {
		return plugin;
	}
}