package one.lifetab.mc.servercontrol.utility;

import one.lifetab.mc.servercontrol.Servercontrol;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import static one.lifetab.mc.servercontrol.Servercontrol.PREFIX;
import static one.lifetab.mc.servercontrol.utility.Send.broadcast;
import static one.lifetab.mc.servercontrol.utility.Send.msg;

public class Messages {
    public static void helpMsg(@NotNull CommandSender sender) {
        msg(sender, "");
        msg(sender, "&0&m                 " + PREFIX + "&0&m                 &r");
        msg(sender, "&0│ &a/sc help &r&0- &cShows this help");
        msg(sender, "&0│ &a/sc version &r&0- &cShows the current version");
        msg(sender, "&0│ &a/sc reload &r&0- &cReloads the config");
        msg(sender, "&0&m                                                               &r");
        msg(sender, "&0│ &a/sc restart <seconds> &r&0- &cRestarts the server");
        msg(sender, "&0&m                                                               &r");
        msg(sender, "");
    }

    public static void versionMsg(@NotNull CommandSender sender) {
        msg(sender, PREFIX + "&cVersion: &a" + Servercontrol.getPluginVersion());
    }

    public static void restartMsg(int seconds) {
        for (int j = 0; j < 300; j++) {
            broadcast(" ");
        }
        broadcast("&0&m                 " + PREFIX + "&0&m                 &r");
        broadcast(" ");
        broadcast("&0│ &aServer will restart in &c" + seconds + " &aseconds&r");
        broadcast(" ");
        broadcast("&0&m                                                               &r");
    }

    public static void noPermission(@NotNull CommandSender sender) {
        msg(sender, PREFIX + "&cYou don't have permission to use this command!");
    }

    public static void restartMsg1() {
        for (int j = 0; j < 300; j++) {
            broadcast(" ");
        }
        broadcast("&0&m                 " + PREFIX + "&0&m                 &r");
        broadcast(" ");
        broadcast("&0│ &aRestarting server...");
        broadcast(" ");
        broadcast("&0&m                                                               &r");
    }
}
