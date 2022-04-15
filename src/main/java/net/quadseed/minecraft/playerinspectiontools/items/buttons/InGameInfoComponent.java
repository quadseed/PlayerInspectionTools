package net.quadseed.minecraft.playerinspectiontools.items.buttons;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InGameInfoComponent {

    public static ItemStack getItem(Player targetPlayer) {
        ItemStack infoSymbol = new ItemStack(Material.MAP);
        ItemMeta infoSymbolMeta = infoSymbol.getItemMeta();
        infoSymbolMeta.setDisplayName("In-Game Information");
        infoSymbolMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        infoSymbolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> infoLore = new ArrayList<>();
        Location targetLocation = targetPlayer.getLocation();
        infoLore.add(ChatColor.RED + "Health: " + Math.floor(targetPlayer.getHealth()) + "/" + Math.floor(targetPlayer.getMaxHealth()));
        infoLore.add(ChatColor.LIGHT_PURPLE + "Food Level: " + targetPlayer.getFoodLevel());
        infoLore.add(ChatColor.BLUE + "Dimension: " + targetPlayer.getWorld().getEnvironment().name());
        infoLore.add(ChatColor.GREEN + "Location: X=" + targetLocation.getBlockX() + " Y=" + targetLocation.getBlockY() + " Z=" + targetLocation.getBlockZ());
        infoLore.add("");
        infoLore.add(ChatColor.DARK_GRAY + "Last Updated: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date()));
        infoSymbolMeta.setLore(infoLore);
        infoSymbol.setItemMeta(infoSymbolMeta);

        return infoSymbol;
    }
}
