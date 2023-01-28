package Game.Location.BattleLoc;

import Game.Obstacle.Bear;
import Game.Obstacle.Obstacle;
import Game.Player;

public class River extends BattleLoc {
    private Bear bear = new Bear();

    public River(Player player) {
        super(player, "River", 5, 3);
    }

    @Override
    public boolean onLocation() {
        if (!getPlayer().getInventory().isWater()) {
            System.out.println("Nehire hosgeldin " + getPlayer().getName());
            System.out.println("Burada seni `Ayilar` bekliyor olacak dikkat et !!!");
            int bearNumber = Obstacle.obstacleNumber();
            System.out.println("Ayilarin adeti : " + bearNumber);
            System.out.println("1 -> Savasmak \n2 -> Cikis");
            System.out.print("Seciminiz : ");
            int choose = input.nextInt();
            while (1 > choose || choose > 2) {
                System.out.print("Gerersiz deger, tekrar giriniz : ");
                choose = input.nextInt();
            }
            switch (choose) {
                case 1:
                    for (int i = 0; i < bearNumber; i++) {
                        combat(new Bear());
                    }
                    if (getPlayer().getHealth() <= 0) {
                        return false;
                    } else {
                        getPlayer().setMoney(getPlayer().getMoney() + bearNumber * bear.getMoney());
                        getPlayer().getInventory().setWater(true);
                        System.out.println("!!!! Water odulunu kazandiniz !!!!");
                    }
                    break;
                case 2:
                    return true;
            }
            return true;
        } else {
            System.out.println("Water odulunu aldiniz. Bir daha giris yapamazsiniz !");
        }
        return true;
    }
}
