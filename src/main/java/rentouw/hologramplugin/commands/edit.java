package rentouw.hologramplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rentouw.hologram.plugin.file.Createholo;
import rentouw.hologram.plugin.file.Deleteholo;

/**
 * Handler for the /hgedit command. parrameters: (hologram id) (edit text)
 * 
 * @author Rentouw
 */
public class edit implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("HOLOGRAM: HG commands need to be executed by a player.");
			return false;
		}
		Player player = (Player) sender;
		if (args.length == 2) {
			String id = args[0];
			String text = args[1];
			String Sdata = rentouw.hologram.plugin.file.IDlist.CheckID(id);
			String data[] = Sdata.split(","); // 0 = x 1 = y 2 = z 3 = naam 4 =
												// info text
			Deleteholo.Delete(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), player);
			Createholo.Create(text, Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
					player);
			player.sendMessage("[HOLOGRAM]:: The text of " + id + " is edited from " + data[3] + " to " + text);
			return true;
		} else {
			player.sendMessage("[HOLOGRAM]:: hgedit needs 2 things not " + args.length);
			return false;
		}
	}
}
