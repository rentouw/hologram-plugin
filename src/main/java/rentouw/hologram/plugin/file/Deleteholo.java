package rentouw.hologram.plugin.file;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;

public class Deleteholo {
	private static ArmorStand armor;
	private static World werold;

	@SuppressWarnings("null")
	public static boolean Delete(String ID, int x, int y, int z, Player player) {
		player.getWorld();
		Location loc = null;
		loc.setX(x);
		loc.setY(y);
		loc.setZ(z);
		armor = (ArmorStand) werold.getNearbyEntities(loc, 1, 1, 1);
		armor.remove();
		return false;
	}
}
