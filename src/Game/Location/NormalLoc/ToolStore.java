package Game.Location.NormalLoc;

import Game.Player;
import Game.Tools.*;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "ToolStore", 2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Magazaya Hosgeldiniz ! ------");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Cikis Yap");
        System.out.print("Seciminiz : ");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.print("Gecersiz deger, tekrar giriniz : ");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                break;
        }
        return true;
    }

    public void printWeapon() {
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - "
                    + weapon.getName() + "\t< Hasari : " + weapon.getDamage() + " , Fiyati : " + weapon.getPrice());
        }
    }

    public void buyWeapon() {
        System.out.print("Satin almak istediginiz silahi seciniz : ");
        int selectWeaponID = input.nextInt();
        while (1 > selectWeaponID || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Gecersiz giris, tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                System.out.println("Yeterli paraniz bulunmamaktadir !");
            } else {
                System.out.println(selectedWeapon.getName() + " silahini satin aldiniz !");
                int balance = getPlayer().getMoney() - selectedWeapon.getPrice();
                getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmor() {
        for (Armor armor : Armor.armors()) {
            System.out.printf("%d - %s \t Engelleme : %d , Fiyati : %d\n", armor.getId(), armor.getName(), armor.getBlock(), armor.getPrice());
        }
    }

    public void buyArmor() {
        System.out.print("Satin almak istediginiz zirhi seciniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.print("Gecersiz giris, tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorByID(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                System.out.println("Yeterli paraniz bulunmamaktadir !!");
            } else {
                System.out.println(selectedArmor.getName() + " Zirhini satin aldiniz !");
                int balance = getPlayer().getMoney() - selectedArmor.getPrice();
                getPlayer().setMoney(balance);
                System.out.println("Kalan bakiyeniz : " + getPlayer().getMoney());
                getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
