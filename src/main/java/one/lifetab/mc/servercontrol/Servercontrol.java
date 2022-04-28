package one.lifetab.mc.servercontrol;

import one.lifetab.mc.servercontrol.commands.ServerControlCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Servercontrol extends JavaPlugin {
    public static String ConsolePREFIX = "&r&0[&rServerControl&r&0]&r ";
    public static String PREFIX = "&r&0│ &9&lServer Control&r&0│&r ";
    public static Servercontrol INSTANCE;
    public Servercontrol() {
        INSTANCE = this;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        log("&0---------------│ &6&lServer Control &r&0│---------------&r");
        log("&r&0│ &aServerControl has been enabled!");
        log("&r&0│ &aVersion: &r&c" + getPluginVersion());
        log("&r&0│ &bRegistering commands...");
        register();
        log("&r&0│ &aCommands have been registered!");
        log("&r&0│ &aPlugin by .LIFETAB#6932");
        log("&r&0│ &aHave fun!");
        log("&0---------------│ &6&lServer Control &r&0│---------------&r");
    }

    @Override
    public void onDisable() {
        log("&aServerControl has been disabled!");
    }

    public void log(String msg){
        msg = ChatColor.translateAlternateColorCodes('&', ConsolePREFIX + msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    private void register() {
        Objects.requireNonNull(Bukkit.getPluginCommand("sc")).setExecutor(new ServerControlCommand());
    }

    public static String getPluginVersion() {
        String version = INSTANCE.getDescription().getVersion();
        return Objects.requireNonNull(version);
    }
}
