package net.quadseed.minecraft.playerinspectiontools;

import net.quadseed.minecraft.playerinspectiontools.menugui.BaseMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class PlayerActionListener implements Listener {

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
