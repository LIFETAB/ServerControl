package one.lifetab.mc.servercontrol.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ServerControlCommand implements CommandExecutor, TabCompleter {

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
                Commands.restart(sender, args);
                return true;
            }
            Commands.help(sender);
            return true;
        }
        Commands.help(sender);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabCompletions = new ArrayList<>();
        if (args.length == 1) {
            tabCompletions.add("help");
            tabCompletions.add("version");
            tabCompletions.add("reload");
            tabCompletions.add("restart");
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("restart")) {
            for (int i = 0; i <= 60; i=i+10) {
                tabCompletions.add(String.valueOf(i));
            }
        }

        return tabCompletions;
    }
}