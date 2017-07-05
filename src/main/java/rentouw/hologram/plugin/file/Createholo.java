package rentouw.hologram.plugin.file;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Createholo {
	private static World world;
	private static ArmorStand armor;
	private static String UUIDS;

	@SuppressWarnings("null")
	public static String Create(String text, double x, double y, double z, Player player) {
		world = player.getWorld();
		Location loc = null;
		loc.setX(x);
		loc.setY(y);
		loc.setZ(z);
		armor = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
		UUIDS = armor.getUniqueId().toString();
		armor.setCustomName(text);
		armor.setCustomNameVisible(true);
		armor.setInvulnerable(true);
		armor.setVisible(false);
		return UUIDS;
	}
}
