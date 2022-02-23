package net.quadseed.minecraft.playerinspectiontools.menugui;

import net.quadseed.minecraft.playerinspectiontools.PlayerInspectionTools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class PlayerListMenu extends BaseMenu {

    protected int page = 0;

    protected int index = 0;

    public PlayerListMenu(MenuUtility menuUtility) {
        super(menuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.GREEN + "In-Game Player List ("
                + Bukkit.getServer().getOnlinePlayers().size() + " / " +
                Bukkit.getServer().getMaxPlayers() + ")";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void InventoryClickHandler(InventoryClickEvent event) {

    }

    @Override
    public void setItems() {
        this.setControlSection();

        ArrayList<Player> players = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
        if (!players.isEmpty()) {
            for (int i = 0; i < 45; i++) {
                index = 45 * page + i;

                if (index >= players.size()) {
                    break;
                }

                if (players.get(index) != null) {
                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    ItemMeta headMeta = playerHead.getItemMeta();
                    SkullMeta skullMeta = (SkullMeta) headMeta;
                    skullMeta.setDisplayName(ChatColor.GOLD + players.get(index).getName());
                    skullMeta.setOwningPlayer(players.get(index));
                    skullMeta.getPersistentDataContainer().set(new NamespacedKey(PlayerInspectionTools.getPlugin(), "uuid"), PersistentDataType.STRING, players.get(index).getUniqueId().toString());

                    playerHead.setItemMeta(skullMeta);
                    inventory.addItem(playerHead);
                }

            }
        }

    }

    public void setControlSection() {

        ItemStack left = new ItemStack(Material.STONE_BUTTON);
        ItemMeta leftMeta = left.getItemMeta();
        leftMeta.setDisplayName(ChatColor.DARK_PURPLE + "Previous Page");
        leftMeta.addEnchant(Enchantment.LUCK, 1, true);
        leftMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        left.setItemMeta(leftMeta);
        inventory.setItem(48, left);

        ItemStack pageIndex = new ItemStack(Material.MAP, page);
        ItemMeta meta2 = pageIndex.getItemMeta();
        meta2.setDisplayName(ChatColor.DARK_GREEN + "Page" + (page + 1));
        meta2.addEnchant(Enchantment.LUCK, 1, true);
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pageIndex.setItemMeta(meta2);
        inventory.setItem(49, pageIndex);

        ItemStack right = new ItemStack(Material.STONE_BUTTON);
        ItemMeta rightMeta = right.getItemMeta();
        rightMeta.setDisplayName(ChatColor.DARK_PURPLE + "Next Page");
        rightMeta.addEnchant(Enchantment.LUCK, 1, true);
        rightMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        right.setItemMeta(rightMeta);
        inventory.setItem(50, right);

    }
}
