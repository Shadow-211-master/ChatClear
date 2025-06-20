package de.Jayluk.chatClear;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public final class ChatClear extends JavaPlugin implements CommandExecutor {

    public static FileConfiguration config;


    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        this.getCommand("clearchat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("clearchat.use")) {
            sender.sendMessage(ChatClear.config.getString("ClearChat.player"));
            return true;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 100; i++) {
                player.sendMessage(" ");
            }
        }

        Bukkit.broadcastMessage("§aDer Chat wurde von §c" + sender.getName() + " §agecleart.");
        return true;
    }
}