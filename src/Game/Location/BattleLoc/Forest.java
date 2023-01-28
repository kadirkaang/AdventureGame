package Game.Location.BattleLoc;

import Game.Obstacle.Obstacle;
import Game.Obstacle.Vampire;
import Game.Player;

public class Forest extends BattleLoc {
    private Vampire vampire = new Vampire();

    public Forest(Player player) {
        super(player, "Forest", 3, 2);
    }

    @Override
    public boolean onLocation() {
        if (!getPlayer().getInventory().isFirewood()) {
            System.out.println("Ormana hosgeldin " + getPlayer().getName());
            System.out.println("Burada seni `Vampirler` bekliyor olacak dikkat et !!!");
            int vampireNumber = Obstacle.obstacleNumber();
            System.out.println("Vampirlerin adeti : " + vampireNumber);
            System.out.println("1 -> Savasmak \n2 -> Cikis");
            System.out.print("Seciminiz : ");
            int choose = input.nextInt();
            while (1 > choose || choose > 2) {
                System.out.print("Gerersiz deger, tekrar giriniz : ");
                choose = input.nextInt();
            }
            switch (choose) {
                case 1:
                    for (int i = 0; i < vampireNumber; i++) {
                        combat(new Vampire());
                    }
                    if (getPlayer().getHealth() <= 0) {
                        return false;
                    } else {
                        getPlayer().setMoney(getPlayer().getMoney() + vampireNumber * vampire.getMoney());
                        getPlayer().getInventory().setFirewood(true);
                        System.out.println("!!!! Firewood odulunu kazandiniz !!!!");
                    }
                    break;
                case 2:
                    return true;
            }
            return true;
        } else {
            System.out.println("Firewood odulunu aldiniz. Bir daha giris yapamazsiniz !!");
        }
        return true;
    }
}
