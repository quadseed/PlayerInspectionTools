package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class QuitComponent {

    public static ItemStack getItem() {
        ItemStack item = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BLUE + "back to Previous Page");
        item.setItemMeta(itemMeta);

        return item;
    }
}
