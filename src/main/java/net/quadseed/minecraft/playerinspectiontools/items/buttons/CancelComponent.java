package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CancelComponent {

    public static ItemStack getItem() {
        ItemStack cancelSymbol = new ItemStack(Material.BARRIER);
        ItemMeta cancelSymbolMeta = cancelSymbol.getItemMeta();
        cancelSymbolMeta.setDisplayName("Cancel");

        cancelSymbol.setItemMeta(cancelSymbolMeta);

        return cancelSymbol;
    }
}
