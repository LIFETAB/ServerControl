package one.lifetab.mc.servercontrol.commands;

import one.lifetab.mc.servercontrol.utility.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import static one.lifetab.mc.servercontrol.Servercontrol.PREFIX;
import static one.lifetab.mc.servercontrol.utility.Send.broadcast;
import static one.lifetab.mc.servercontrol.utility.Send.msg;

public class Commands {
    public static void help(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.help") || sender instanceof ConsoleCommandSender) {
            Messages.helpMsg(sender);
        }
    }

    public static void version(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.version") || sender instanceof ConsoleCommandSender) {
            Messages.versionMsg(sender);
        }
    }

    public static void reload(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.reload") || sender instanceof ConsoleCommandSender) {
            msg(sender, PREFIX + "&cCommand in development...");
        }
    }

    public static void restart(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.restart") || sender instanceof ConsoleCommandSender) {
            for (int i = 10; i > 0; i--) {
                broadcast(PREFIX + "&cServer restarting in &e" + i + "&c seconds...");
                try {
                    TimeUnit.SECONDS.sleep(1); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.kickPlayer(ChatColor.translateAlternateColorCodes('&',PREFIX + "&cServer restarting... \n&cPlease reconnect in 2 minutes..."));
            }
            Bukkit.spigot().restart();
        }
    }
}
