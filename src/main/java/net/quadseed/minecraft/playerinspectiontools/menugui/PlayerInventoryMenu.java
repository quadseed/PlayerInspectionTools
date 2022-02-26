package net.quadseed.minecraft.playerinspectiontools.menugui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInventoryMenu extends BaseMenu {

    public PlayerInventoryMenu(MenuUtility menuUtility) {
        super(menuUtility);
    }

    @Override
    public String getMenuName() {
        String targetName = super.menuUtility.getInspectionTarget().getName();
        return ChatColor.GREEN + targetName + "'s Inventory";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void InventoryClickHandler(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) {
            return;
        }

        switch (event.getRawSlot()) {
            case 53:
                new PlayerStatusMenu(menuUtility).open();
                break;
        }
    }

    @Override
    public void setItems() {
        Player targetPlayer = super.menuUtility.getInspectionTarget();
        ItemStack[] items = targetPlayer.getInventory().getContents();
        for (int i = 9; i < 36; i++) {
            if (items[i] != null) {
                inventory.setItem(i-9, items[i]);
            }
        }

        for (int i = 0; i < 9; i++) {
            if (items[i] != null) {
                inventory.setItem(36+i, items[i]);
            }
        }

        ItemStack[] armors = targetPlayer.getInventory().getArmorContents();
        for (int i = 0; i < 4; i++) {
            if (items[i] != null) {
                inventory.setItem(48-i, armors[i]);
            }
        }

        for (int i = 27; i < 36; i++) {
            ItemStack border = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
            ItemMeta borderMeta = border.getItemMeta();
            borderMeta.setDisplayName(" ");
            border.setItemMeta(borderMeta);
            inventory.setItem(i, border);
        }

        inventory.setItem(50, targetPlayer.getInventory().getItemInOffHand());

        ItemStack quit = new ItemStack(Material.BARRIER, 1);
        ItemMeta quitMeta = quit.getItemMeta();
        quitMeta.setDisplayName(ChatColor.BLUE + "back to Status Page");
        quit.setItemMeta(quitMeta);

        inventory.setItem(53, quit);
    }
}
