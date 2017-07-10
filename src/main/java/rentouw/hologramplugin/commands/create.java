package rentouw.hologramplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rentouw.hologram.plugin.file.Createholo;
import rentouw.hologram.plugin.file.IDlist;

/**
 * Handler for the /hgcreate command. parrameters: (hologram id) (Ur text) '(x
 * pos) (y pos) (z pos)'
 * 
 * @author Rentouw
 */
public class create implements CommandExecutor {
	private static String data[] = new String[5];

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().info("HOLOGRAM: HG commands need to be executed by a player.");
			return false;
		}
		Player player = (Player) sender;
		player.sendMessage("start checking");
		if (args.length == 5) {
			player.sendMessage("args == 5");
			String id = args[0];
			String text = args[1];
			int x = Integer.parseInt(args[2]);
			int y = Integer.parseInt(args[3]);
			int z = Integer.parseInt(args[4]);
			player.sendMessage("start checkID");
			String Sdata = IDlist.CheckID(id);
			data = Sdata.split(","); // 0 = x 1 = y 2 = z 3 = text 4 = info text
			player.sendMessage("CheckID worked and split");
			if (data[4] == "true") {
				Createholo.Create(text, x, y, z, player);
				player.sendMessage("done");
			} else {
				Createholo.Create(text, x, y, z, player);
				String info = (id + "," + x + "," + y + "," + z + "," + text);
				IDlist.writeToFile(info);
				player.sendMessage("done");
			}
			return true;
		} else {
			player.sendMessage("error");
			return true;
		}
	}
}
