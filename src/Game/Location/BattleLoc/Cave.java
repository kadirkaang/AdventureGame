package Game.Location.BattleLoc;

import Game.Obstacle.Obstacle;
import Game.Obstacle.Zombie;
import Game.Player;

public class Cave extends BattleLoc {
    private Zombie zombie = new Zombie();

    public Cave(Player player) {
        super(player, "Cave", 4, 1);
    }

    @Override
    public boolean onLocation() {
        if (!getPlayer().getInventory().isFood()) {
            System.out.println("Magaraya hosgeldin " + getPlayer().getName());
            System.out.println("Burada seni `Zombie` bekliyor olacak dikkat et !!!");
            int zombieNumber = Obstacle.obstacleNumber();
            System.out.println("Zombilerin adeti : " + zombieNumber);
            System.out.println("1 -> Savasmak \n2 -> Cikis");
            System.out.print("Seciminiz : ");
            int choose = input.nextInt();
            while (1 > choose || choose > 2) {
                System.out.print("Gerersiz deger, tekrar giriniz : ");
                choose = input.nextInt();
            }
            switch (choose) {
                case 1:
                    for (int i = 0; i < zombieNumber; i++) {
                        combat(new Zombie());
                    }
                    if (getPlayer().getHealth() <= 0) {
                        return false;
                    } else {
                        getPlayer().setMoney(getPlayer().getMoney() + zombieNumber * zombie.getMoney());
                        getPlayer().getInventory().setFood(true);
                        System.out.println("!!!! Food odulunu kazandiniz !!!!");
                    }
                    break;
                case 2:
                    return true;
            }
            return true;
        } else {
            System.out.println("Food odulunu aldiniz. Bir daha giris yapamazsiniz !");
        }
        return true;
    }
}
