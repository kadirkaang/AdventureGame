package Game;

import Game.GameCharacter.*;
import Game.Location.*;
import Game.Location.BattleLoc.*;
import Game.Location.NormalLoc.*;


import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        System.out.println("Karakterler");
        System.out.println("-------------------------------");

        GameChar[] gameCharacters = {new Samurai(), new Archer(), new Paladin()};
        for (GameChar gChar : gameCharacters) {
            System.out.println(gChar.getName() +
                    "\t ID : " + gChar.getId() +
                    "\t Hasar : " + gChar.getDamage() +
                    "\t Saglik : " + gChar.getHealth() +
                    "\t Para : " + gChar.getMoney());
        }
        System.out.println("-------------------------------");
        while (true) {
            System.out.print("Lutfen bir karakter seciniz : ");
            int selectChar = input.nextInt();
            switch (selectChar) {
                case 1 -> initPlayer(new Samurai());
                case 2 -> initPlayer(new Archer());
                case 3 -> initPlayer(new Paladin());
                default -> System.out.println("Gecerli bir karakter giriniz !!!");
            }
            if (1 <= selectChar && selectChar <= 3) {
                break;
            }
        }
    }

    public void initPlayer(GameChar gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public void printInfo() {
        System.out.println("--- Silahiniz : " + this.getInventory().getWeapon().getName() +
                "\t Hasari : " + this.getDamage() +
                "\t Saglik : " + this.getHealth() +
                "\t Para : " + this.getMoney() +
                "\t Engelleme : " + this.getInventory().getArmor().getBlock());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
