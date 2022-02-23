package net.quadseed.minecraft.playerinspectiontools;

import net.quadseed.minecraft.playerinspectiontools.items.UnlimitedBook;
import net.quadseed.minecraft.playerinspectiontools.menugui.BaseMenu;
import net.quadseed.minecraft.playerinspectiontools.menugui.MenuUtilityManager;
import net.quadseed.minecraft.playerinspectiontools.menugui.PlayerListMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PlayerActionListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (item == null) {
            return;
        }

        if (!item.isSimilar(UnlimitedBook.getItem())) {
            return;
        }

        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            event.setCancelled(true);
            return;
        }

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            event.setCancelled(true);
            PlayerListMenu vault = new PlayerListMenu(MenuUtilityManager.getMenuUtility(player));
            vault.open();
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof BaseMenu) {
            event.setCancelled(true);
            BaseMenu menu = (BaseMenu) holder;
            menu.InventoryClickHandler(event);
        }
    }
}
