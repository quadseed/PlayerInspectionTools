package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerInfoComponent {

    public static ItemStack getItem(Player targetPlayer) {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta headMeta = playerHead.getItemMeta();
        SkullMeta skullMeta = (SkullMeta) headMeta;
        skullMeta.setDisplayName(ChatColor.GOLD + targetPlayer.getName());
        skullMeta.setOwningPlayer(targetPlayer);
        List<String> lore = new ArrayList<>();

        lore.add("UUID: " + targetPlayer.getUniqueId());
        lore.add("Ping: " + targetPlayer.getPing() + "ms");
        String address = targetPlayer.getAddress().toString();
        lore.add("IP: " + address.substring(address.indexOf("/")+1));
        lore.add("Host: " + targetPlayer.getAddress().getHostName());
        lore.add("Last login: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date(targetPlayer.getLastLogin())));
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Last Updated: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date()));

        skullMeta.setLore(lore);

        playerHead.setItemMeta(skullMeta);

        return playerHead;
    }
}
