package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryComponent {

    public static ItemStack getItem(Player targetPlayer) {
        ItemStack inventorySymbol = new ItemStack(Material.CHEST);
        ItemMeta inventorySymbolMeta = inventorySymbol.getItemMeta();
        inventorySymbolMeta.setDisplayName("Inventory");
        inventorySymbolMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        inventorySymbolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> inventoryLore = new ArrayList<>();
        inventoryLore.add(ChatColor.GREEN + ">> Click to view " + targetPlayer.getName() + "'s Inventory <<");
        inventorySymbolMeta.setLore(inventoryLore);
        inventorySymbol.setItemMeta(inventorySymbolMeta);

        return inventorySymbol;
    }
}
