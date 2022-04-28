package one.lifetab.mc.servercontrol.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ServerControlCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("help")) {
                Commands.help(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("version")) {
                Commands.version(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                Commands.reload(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("restart")) {
                Commands.restart(sender);
                return true;
            }
            Commands.help(sender);
            return true;
        }
        Commands.help(sender);
        return true;
    }
}