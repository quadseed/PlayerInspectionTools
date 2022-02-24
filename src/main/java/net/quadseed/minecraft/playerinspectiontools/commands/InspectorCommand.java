package net.quadseed.minecraft.playerinspectiontools.commands;

import net.quadseed.minecraft.playerinspectiontools.items.UnlimitedBook;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class InspectorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command is only available when issued by the In-Game Administrator.");
            return true;
        }

        Player player = (Player) sender;
        Inventory inventory = player.getInventory();
        if (inventory.firstEmpty() != -1) {
            player.getInventory().addItem(UnlimitedBook.getItem());
            player.sendMessage(ChatColor.GREEN + "Give 1 " + ChatColor.LIGHT_PURPLE + "Unlimited Book" + ChatColor.GREEN + " to " + ChatColor.AQUA + player.getName());
        } else {
            player.sendMessage(ChatColor.RED + "[ERROR] Your inventory is full.");
        }


        return true;
    }
}
