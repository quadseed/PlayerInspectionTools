package net.quadseed.minecraft.playerinspectiontools.menugui;

import net.quadseed.minecraft.playerinspectiontools.items.buttons.CancelComponent;
import net.quadseed.minecraft.playerinspectiontools.items.buttons.ConfirmComponent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ConfirmMenu extends BaseMenu {

    private final String confirmType;

    public ConfirmMenu(MenuUtility menuUtility, String confirmType) {
        super(menuUtility);
        this.confirmType = confirmType;
    }

    @Override
    public String getMenuName() {
        return "Are you really want to " + confirmType + "?";
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
            case EMERALD:
                break;

            case BARRIER:
                new PlayerStatusMenu(menuUtility).open();
                break;
        }
    }

    @Override
    public void setItems() {
        inventory.setItem(2, ConfirmComponent.getItem());

        inventory.setItem(6, CancelComponent.getItem());
    }
}
