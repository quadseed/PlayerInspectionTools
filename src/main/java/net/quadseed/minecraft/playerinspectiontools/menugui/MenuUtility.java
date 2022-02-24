package net.quadseed.minecraft.playerinspectiontools.menugui;

import org.bukkit.entity.Player;

public class MenuUtility {

    private Player owner;

    private Player inspectionTarget;

    public MenuUtility(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getInspectionTarget() {
        return inspectionTarget;
    }

    public void setInspectionTarget(Player inspectionTarget) {
        this.inspectionTarget = inspectionTarget;
    }
}