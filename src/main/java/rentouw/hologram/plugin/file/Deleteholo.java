package rentouw.hologram.plugin.file;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class Deleteholo {
	private static ArmorStand armor;
	private static World werold;

	
	public static boolean Delete(String ID, int x, int y, int z, Player player) {
		Location loc = new Location(player.getWorld(), x, y, z);
		armor = (ArmorStand) werold.getNearbyEntities(loc, 1, 1, 1);
		armor.remove();
		return false;
	}
}
