package Game.Location.BattleLoc;

import Game.Location.Location;
import Game.Obstacle.Obstacle;
import Game.Player;

public abstract class BattleLoc extends Location {
    private int obstacleID;
    private Obstacle monster;

    public BattleLoc(Player player, String name, int id, int obstacleID) {
        super(player, name, id);
        this.obstacleID = obstacleID;
    }

    @Override
    public boolean onLocation() {
        return false;
    }

    public void combat(Obstacle obstacle) {
        this.getPlayer().printInfo();
        System.out.println("--- " + obstacle.getName() +
                " < Hasari : " + obstacle.getDamage() +
                "  Saglik : " + obstacle.getHealth() + " >");
        System.out.println("------------------------------------------");
        int begin = (int) (Math.random() * 2);
        if (begin == 0) {
            while (true) {
                System.out.println(getPlayer().getName() + " --> " + obstacle.getName());
                obstacle.setHealth(Math.max((obstacle.getHealth() - getPlayer().getDamage()), 0));
                System.out.println("Saglik : " + getPlayer().getHealth() + "\t\t|\tCanavarin Sagligi : " + obstacle.getHealth());
                if (obstacle.getHealth() <= 0) {
                    System.out.println("++++++ Canavar oldu ++++++");
                    break;
                }
                System.out.println(obstacle.getName() + " --> " + getPlayer().getName());
                getPlayer().setHealth(Math.max((getPlayer().getHealth() - Math.max((obstacle.getDamage() - getPlayer().getInventory().getArmor().getBlock()), 0)), 0));
                System.out.println("Saglik : " + getPlayer().getHealth() + "\t\t|\tCanavarin Sagligi : " + obstacle.getHealth());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Kahramaniniz oldu. GAME OVER");
                    break;
                }
            }
            System.out.println("------------------------------------------");
        } else {
            while (true) {
                System.out.println(obstacle.getName() + " --> " + getPlayer().getName());
                getPlayer().setHealth(Math.max((getPlayer().getHealth() - Math.max((obstacle.getDamage() - getPlayer().getInventory().getArmor().getBlock()), 0)), 0));
                System.out.println("Saglik : " + getPlayer().getHealth() + "\t\t|\tCanavarin Sagligi : " + obstacle.getHealth());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Kahramaniniz oldu. GAME OVER");
                    break;
                }
                System.out.println(getPlayer().getName() + " --> " + obstacle.getName());
                obstacle.setHealth(Math.max((obstacle.getHealth() - getPlayer().getDamage()), 0));
                System.out.println("Saglik : " + getPlayer().getHealth() + "\t\t|\tCanavarin Sagligi : " + obstacle.getHealth());
                if (obstacle.getHealth() <= 0) {
                    System.out.println("++++++ Canavar oldu ++++++");
                    break;
                }
            }
            System.out.println("------------------------------------------");
        }

    }

    public Obstacle getMonster() {
        return monster;
    }

    public void setMonster(Obstacle monster) {
        this.monster = monster;
    }

    public int getObstacleID() {
        return obstacleID;
    }

    public void setObstacleID(int obstacleID) {
        this.obstacleID = obstacleID;
    }
}
