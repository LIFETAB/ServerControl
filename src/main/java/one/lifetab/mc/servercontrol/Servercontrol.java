package one.lifetab.mc.servercontrol;

import one.lifetab.mc.servercontrol.commands.ServerControlCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Servercontrol extends JavaPlugin {
    public static String ConsolePREFIX = "&r&f[&rServerControl&r&f]&r ";
    public static String PREFIX = "&r&0│ &9&lServer Control&r&0│&r ";
    public static Servercontrol INSTANCE;
    public Servercontrol() {
        INSTANCE = this;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        log("&f---------------│ &6&lServer Control &r&f│---------------&r");
        log("&r&f│ &aServerControl has been enabled!");
        log("&r&f│ &aVersion: &r&c" + getPluginVersion());
        log("&r&f│ &bRegistering commands...");
        registerCommands();
        log("&r&f│ &aCommands have been registered!");
        log("&r&f│ &aPlugin by .LIFETAB#6932");
        log("&r&f│ &aHave fun!");
        log("&f---------------│ &6&lServer Control &r&f│---------------&r");
    }

    @Override
    public void onDisable() {
        log("&aServerControl has been disabled!");
    }

    public void log(String msg){
        msg = ChatColor.translateAlternateColorCodes('&', ConsolePREFIX + msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    private void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("sc")).setExecutor(new ServerControlCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("sc")).setTabCompleter(new ServerControlCommand());
    }


    public static String getPluginVersion() {
        String version = INSTANCE.getDescription().getVersion();
        return Objects.requireNonNull(version);
    }
}
