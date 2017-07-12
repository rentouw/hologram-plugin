package rentouw.hologram.plugin.file;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Deleteholo {	
	public static boolean Delete(String ID, int x, int y, int z, Player player) {
		Bukkit.getLogger().info("START DELETE");
		Location loc = new Location(player.getWorld(), x, y, z);
		World a = player.getWorld();
		Bukkit.getLogger().info("I HAVE ALL THE ID's");
		Collection<Entity> b = a.getNearbyEntities(loc, 2, 2, 2);
		for (Entity entit : b) {
			entit.remove();
		}
		return false;
	}
}
