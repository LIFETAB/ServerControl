package one.lifetab.mc.servercontrol.commands;

import one.lifetab.mc.servercontrol.Servercontrol;
import one.lifetab.mc.servercontrol.utility.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static one.lifetab.mc.servercontrol.Servercontrol.PREFIX;
import static one.lifetab.mc.servercontrol.utility.Send.msg;

public class Commands {
    public static void help(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.help")) {
            Messages.helpMsg(sender);
        }
    }

    public static void version(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.version")) {
            Messages.versionMsg(sender);
        }
    }

    public static void reload(@NotNull CommandSender sender) {
        msg(sender, PREFIX + "&cCommand in development...");
    }

    public static void restart(@NotNull CommandSender sender) {
        if (sender.hasPermission("servercontrol.restart")) {
            Bukkit.spigot().restart();
        }
    }
}
