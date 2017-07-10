package rentouw.hologramplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Handler for the /hgdelete command. parrameters: (hologram id)
 * 
 * @author Rentouw
 */
public class delete implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("HOLOGRAM: HG commands need to be executed by a player.");
			return false;
		}

		Player player = (Player) sender;
		if (args.length == 1) {
			String id = args[0];
			String Sdata = rentouw.hologram.plugin.file.IDlist.CheckID(id);
			String data[] = Sdata.split(","); // 0 = x 1 = y 2 = z 3 = naam 4 =
												// info text
			//if (data[4] == "true") {
				rentouw.hologram.plugin.file.Deleteholo.Delete(id, Integer.parseInt(data[0]), Integer.parseInt(data[1]),
						Integer.parseInt(data[2]), player);
			//} else {
			//	player.sendMessage("[HOLOGRAM]::There is no " + id + " hologram.");
			//}
			return true;
		} else {
			return false;
		}
	}
}
