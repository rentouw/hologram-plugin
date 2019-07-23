package rentouw.hologram.plugin.file;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Createholo {
    public static void Create(String text, double x, double y, double z, Player player) {
        World world = player.getWorld();
        Location loc = new Location(world, x, y, z);
        ArmorStand armor = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        armor.setCustomName(text);
        armor.setCustomNameVisible(true);
        armor.setInvulnerable(true);
        armor.setVisible(false);
    }
}
