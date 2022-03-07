package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ManagementComponent {

    public static ItemStack getItem() {
        ItemStack manageSymbol = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta manageSymbolMeta = manageSymbol.getItemMeta();
        manageSymbolMeta.setDisplayName("Management");
        manageSymbolMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        manageSymbolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        manageSymbolMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        manageSymbol.setItemMeta(manageSymbolMeta);

        return manageSymbol;
    }
}
