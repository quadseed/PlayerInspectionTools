package net.quadseed.minecraft.playerinspectiontools.menugui;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerStatusMenu extends BaseMenu {

    public PlayerStatusMenu(MenuUtility menuUtility) {
        super(menuUtility);
    }

    @Override
    public String getMenuName() {
        String targetName = super.menuUtility.getInspectionTarget().getName();
        return ChatColor.GOLD + "Player Status (" + targetName + ")";
    }

    @Override
    public int getSlots() {
        return 36;
    }

    @Override
    public void InventoryClickHandler(InventoryClickEvent event) {

    }

    @Override
    public void setItems() {
        Player targetPlayer = super.menuUtility.getInspectionTarget();
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta headMeta = playerHead.getItemMeta();
        SkullMeta skullMeta = (SkullMeta) headMeta;
        skullMeta.setDisplayName(ChatColor.GOLD + targetPlayer.getName());
        skullMeta.setOwningPlayer(targetPlayer);
        List<String> lore = new ArrayList<>();
        lore.add("UUID: " + targetPlayer.getUniqueId());
        lore.add("Ping: " + targetPlayer.getPing());
        lore.add("IP: " + targetPlayer.getAddress());
        lore.add("Host: " + targetPlayer.getAddress().getHostName());
        lore.add("Last seen: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date(targetPlayer.getLastSeen())));

        skullMeta.setLore(lore);

        playerHead.setItemMeta(skullMeta);
        inventory.setItem(1, playerHead);

        ItemStack inventorySymbol = new ItemStack(Material.CHEST);
        ItemMeta inventorySymbolMeta = inventorySymbol.getItemMeta();
        inventorySymbolMeta.setDisplayName("Inventory");
        inventorySymbolMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        inventorySymbolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> inventoryLore = new ArrayList<>();
        inventoryLore.add(ChatColor.GREEN + ">> Click to view " + targetPlayer.getName() + "'s Inventory <<");
        inventorySymbolMeta.setLore(inventoryLore);
        inventorySymbol.setItemMeta(inventorySymbolMeta);

        inventory.setItem(19, inventorySymbol);

        ItemStack infoSymbol = new ItemStack(Material.MAP);
        ItemMeta infoSymbolMeta = infoSymbol.getItemMeta();
        infoSymbolMeta.setDisplayName("In-Game Information");
        infoSymbolMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
        infoSymbolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> infoLore = new ArrayList<>();
        Location targetLocation = targetPlayer.getLocation();
        infoLore.add(ChatColor.RED + "Health: " + Math.floor(targetPlayer.getHealth()) + "/" + Math.floor(targetPlayer.getMaxHealth()));
        infoLore.add(ChatColor.GREEN + "Location: X=" + targetLocation.getBlockX() + " Y=" + targetLocation.getBlockY() + " Z=" + targetLocation.getBlockZ());
        infoSymbolMeta.setLore(infoLore);
        infoSymbol.setItemMeta(infoSymbolMeta);

        inventory.setItem(22, infoSymbol);

        ItemStack quit = new ItemStack(Material.BARRIER, 1);
        ItemMeta quitMeta = quit.getItemMeta();
        quitMeta.setDisplayName(ChatColor.BLUE + "back to PlayerList");
        quit.setItemMeta(quitMeta);

        inventory.setItem(7, quit);

    }
}
