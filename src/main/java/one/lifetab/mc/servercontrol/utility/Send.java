package one.lifetab.mc.servercontrol.utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Send {
    public static void msg(@NotNull CommandSender player, @NotNull String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
