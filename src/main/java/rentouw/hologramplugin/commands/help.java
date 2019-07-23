package rentouw.hologramplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Handler for the /hghelp command. parrameters: none
 *
 * @author Rentouw
 */
public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info("HOLOGRAM: HG commands need to be executed by a player.");
            return false;
        }
        Player player = (Player) sender;
        // make the text that needs to be displayed if u type /hghelp
        String[] messages = new String[6];
        messages[0] = (ChatColor.AQUA + "----------------------" + ChatColor.RED + "Hologram" + ChatColor.AQUA + "----------------------");
        messages[1] = (ChatColor.AQUA + "          /hgcreate (hologram id) (Ur text) '(x pos) (y pos)");
        messages[2] = (ChatColor.AQUA + "           (z pos)'");
        messages[3] = (ChatColor.AQUA + "          /hgedit (hologram id) (edit text)");
        messages[4] = (ChatColor.AQUA + "          /hgdelete (hologram id)");
        messages[5] = (ChatColor.AQUA + "-------------------" + ChatColor.RED + "Made-by-Rentouw" + ChatColor.AQUA + "------------------");
        // Send massage to the player
        for (String mes : messages) {
            player.sendMessage(mes);
        }
        return true;
    }
}
