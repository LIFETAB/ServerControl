package one.lifetab.mc.servercontrol.commands;

import net.kyori.adventure.text.Component;
import one.lifetab.mc.servercontrol.Servercontrol;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.jetbrains.annotations.NotNull;
import one.lifetab.mc.servercontrol.utility.Messages;


import static one.lifetab.mc.servercontrol.Servercontrol.*;
import static one.lifetab.mc.servercontrol.utility.Send.msg;
import static org.bukkit.Bukkit.getServer;
import static sun.security.krb5.SCDynamicStoreConfig.getConfig;


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
            INSTANCE.reloadConfig();
            msg(sender, PREFIX + "&aConfig reloaded!");
        }
    }

    public static void restart(@NotNull CommandSender sender, String[] args) {
        if (sender.hasPermission("servercontrol.restart") || sender instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                try {
                    Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    msg(sender, PREFIX + "&cPlease enter a valid number of seconds.");
                    return;
                }
                int restartTime = Integer.parseInt(args[1]);
                restartServer(restartTime);
            } else {
                //Get Information from config.yml
                int restartTime = INSTANCE.getConfig().getInt("restart.time");
                restartServer(restartTime);
            }
        }
    }
    private static void restartServer(int restartTime) {
        INSTANCE.getServer().getScheduler().scheduleSyncDelayedTask(INSTANCE, () -> {
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.kick(Component.text(ChatColor.translateAlternateColorCodes('&',PREFIX + "\n&cServer is restarting... &bPlease reconnect in 2 minutes!")), PlayerKickEvent.Cause.RESTART_COMMAND);
            }
            Bukkit.spigot().restart();
        }, (restartTime+2) * 20L);
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = restartTime; i >= 0; i--) {
                    Messages.restartMsg(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Messages.restartMsg1();
            }
        })).start();
    }
}
