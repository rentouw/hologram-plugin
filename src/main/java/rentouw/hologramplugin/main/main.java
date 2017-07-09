package rentouw.hologramplugin.main;

import org.bukkit.plugin.java.JavaPlugin;
import rentouw.hologramplugin.commands.*;

public class main extends JavaPlugin {

	@Override
	public void onEnable() {
		// create ID.yml file in plugins/
		rentouw.hologram.plugin.file.IDlist.writeToFile("ID LIST,DO NOT EDIT,STOP");
		// Get command executor
		getCommand("hgdelete").setExecutor(new delete());
		getCommand("hghelp").setExecutor(new help());
		getCommand("hgedit").setExecutor(new edit());
		getCommand("hgcreate").setExecutor(new create());
		// Send start of plugin
		getLogger().info("Hologram plugin version 0.0.1-SNAPSHOT by rentouw is starting!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Hologram plugin stopped!");
	}
}
