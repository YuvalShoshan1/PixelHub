package me.Yuval.pixelhub;

import me.Yuval.pixelhub.utils.Utils;

public class HelpMSG {
    private String helpMSG = Utils.colour("&7&m-*----&r &3PixelHub &7&m----*-" +
            "\n" + "" +
            "\n" + "&7&oMade by &3Yuval Shoshan" +
            "\n" + "" +
            "\n" + "&7+ &3Damage &8»&r &7Disable/Enable Player Damage." +
            "\n" + "&7+ &3Weather &8»&r &7Disable/Enable Weather Changing." +
            "\n" + "&7+ &3PlayerDrop &8»&r &7Disable/Enable Player Drops." +
            "\n" + "&7+ &3Hunger &8»&r &7Disable/Enable Player Hunger." +
            "\n" + "&7+ &3Place &8»&r &7Disable/Enable Player Block Place." +
            "\n" + "&7+ &3MoveItem &8»&r &7Disable/Enable Moving Item In Inventory." +
            "\n" + "&7+ &3Pickup &8»&r &7Disable/Enable Player From Picking Up Items." +
            "\n" + "&7+ &3Help &8»&r &7Showing this message." +
            "\n" + "&7&m--*------------*--");

    public String getHelpMSG() {
        return helpMSG;
    }
}
