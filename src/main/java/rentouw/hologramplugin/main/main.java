package rentouw.hologramplugin.main;

import org.bukkit.plugin.java.JavaPlugin;

import rentouw.hologramplugin.commands.create;
import rentouw.hologramplugin.commands.delete;
import rentouw.hologramplugin.commands.edit;
import rentouw.hologramplugin.commands.help;

public class main extends JavaPlugin {

	@Override
	public void onDisable() {
		getLogger().info("Hologram plugin stopped!");
	}

	@Override
	public void onEnable() {
		// create ID.yml file in plugins/
		rentouw.hologram.plugin.file.IDlist.writeToFile("ID LIST");
		// Get command executor
		getCommand("hgdelete").setExecutor(new delete());
		getCommand("hghelp").setExecutor(new help());
		getCommand("hgedit").setExecutor(new edit());
		getCommand("hgcreate").setExecutor(new create());
		// Send start of plugin
		getLogger().info("Hologram plugin version 0.0.1 by rentouw is starting!");
	}
}
