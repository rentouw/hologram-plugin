package rentouw.hologram.plugin.file;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Deleteholo {
	public static boolean Delete(int x, int y, int z, Player player) {
		Location loc = new Location(player.getWorld(), x, y, z);
		World a = player.getWorld();
		Collection<Entity> b = a.getNearbyEntities(loc, 2, 2, 2);
		for (Entity en : b) {
			Location loca = en.getLocation();
			if (loca.equals(loc)) {
				en.remove();
			}
		}
		return true;
	}
}