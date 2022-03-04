package net.quadseed.minecraft.playerinspectiontools.menugui;

import net.quadseed.minecraft.playerinspectiontools.items.buttons.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

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
        return 9;
    }

    @Override
    public void InventoryClickHandler(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) {
            return;
        }

        switch (event.getCurrentItem().getType()) {
            case CHEST:
                new PlayerInventoryMenu(MenuUtilityManager.getMenuUtility((Player) event.getWhoClicked())).open();
                break;

            case BARRIER:
                new PlayerListMenu(MenuUtilityManager.getMenuUtility((Player) event.getWhoClicked())).open();
                break;
        }
    }

    @Override
    public void setItems() {
        Player targetPlayer = super.menuUtility.getInspectionTarget();

        inventory.setItem(0, PlayerInfoComponent.getItem(targetPlayer));

        inventory.setItem(2, InGameInfoComponent.getItem(targetPlayer));

        inventory.setItem(4, InventoryComponent.getItem(targetPlayer));

        inventory.setItem(6, ManagementComponent.getItem());

        inventory.setItem(8, QuitComponent.getItem());

    }
}
