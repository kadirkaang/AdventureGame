package Game.Location.NormalLoc;

import Game.Player;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "SafeHouse", 1);
    }

    @Override
    public boolean onLocation() {
        String charName = getPlayer().getCharName();
        switch (charName) {
            case "Samurai" -> getPlayer().setHealth(21);
            case "Archer" -> getPlayer().setHealth(18);
            case "Paladin" -> getPlayer().setHealth(24);
        }
        System.out.println("Guvenli evdesiniz !!");
        System.out.println("Caniniz yenilendi !!");
        System.out.println("Sahip olunan oduller :");
        System.out.println("Firewood -> " + getPlayer().getInventory().isFirewood());
        System.out.println("Food -> " + getPlayer().getInventory().isFood());
        System.out.println("Water -> " + getPlayer().getInventory().isWater());
        return true;
    }
}
