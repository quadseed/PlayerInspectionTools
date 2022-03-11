package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfirmComponent {

    public static ItemStack getItem() {
        ItemStack confirmSymbol = new ItemStack(Material.EMERALD);
        ItemMeta confirmSymbolMeta = confirmSymbol.getItemMeta();
        confirmSymbolMeta.setDisplayName("Confirm");

        confirmSymbol.setItemMeta(confirmSymbolMeta);

        return confirmSymbol;
    }
}
