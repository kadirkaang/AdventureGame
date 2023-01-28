package Game;

import Game.Location.*;
import Game.Location.BattleLoc.*;
import Game.Location.NormalLoc.*;

import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner input = new Scanner(System.in);

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void start() {
        System.out.println("Macera oyununa hosgeldiniz !");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        this.player = new Player(playerName);
        System.out.println(player.getName() + " hosgeldin, hayatta kalabilecek misin ? Gorelim !!");
        System.out.println("Lutfen bir karakter secin !! ");
        player.selectChar();
        while (true) {
            player.printInfo();
            Location[] locations = {new SafeHouse(player), new ToolStore(player), new Forest(player), new Cave(player), new River(player)};
            System.out.println("------------------------");
            System.out.println("###### Bolgeler ######");
            for (Location location : locations) {
                System.out.println(location.getId() + " : " + location.getName());
            }
            System.out.println("0 : " + "Cikis Yap");
            System.out.println("------------------------");
            int selectLoc;
            while (true) {
                System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz : ");
                selectLoc = input.nextInt();
                if (0 <= selectLoc && selectLoc <= locations.length) {
                    break;
                } else {
                    System.out.println("Lutfen gecerli bir bolge giriniz !!!");
                }
            }
            if (selectLoc == 0) {
                break;
            }
            if (selectLoc == 1 && this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isFirewood()) {
                System.out.println("Sahip olunan oduller :");
                System.out.println("Firewood -> " + getPlayer().getInventory().isFirewood());
                System.out.println("Food -> " + getPlayer().getInventory().isFood());
                System.out.println("Water -> " + getPlayer().getInventory().isWater());
                System.out.println("!!!! Butun odulleri topladin, Tebrikler");
                System.out.println("----!! YOU WIN !!----");

                break;
            }
            if (!locations[selectLoc - 1].onLocation()) {
                System.out.println("GAME OVER !");
                break;
            }
        }
    }
}
