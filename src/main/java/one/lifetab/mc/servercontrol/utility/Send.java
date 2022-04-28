package one.lifetab.mc.servercontrol.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Send {
    public static void msg(@NotNull CommandSender player, @NotNull String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
    public static void broadcast(@NotNull String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }
}
