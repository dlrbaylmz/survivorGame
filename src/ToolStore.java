public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz!");
        System.out.println("1 - Silahlar ");
        System.out.println("2 - Zırhlar ");
        System.out.println("3 - Çıkış Yap ");
        System.out.println("Seçiminiz: ");
        int selectCase = Location.input.nextInt();
        while(selectCase < 1 || selectCase > Weapon.weapons().length ){
            System.out.println("Geçersiz değer , tekrar giriniz : ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1 :
                printWeapon();
                buyWeapon();
            case 2 :
                printArmor();
            case 3 :
                System.out.println("Görüşmek üzere!!");
                return true;
        }

        return true;
    }
    public void printWeapon(){
        System.out.println("Silahlar");
        for (Weapon w : Weapon.weapons()) {
            System.out.println( w.getId() +"-"+ w.getName() +
                    " < Para : " + w.getPrice() +
                    ", Hasar : " + w.getDamage() + " >");
        }
    }

    public void buyWeapon(){
        System.out.println("Bir silah seçiniz : ");
        int selectWeapon = input.nextInt();
        while(selectWeapon < 1 || selectWeapon > Weapon.weapons().length ){
            System.out.println("Geçersiz değer , tekrar giriniz : ");
            selectWeapon = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);

        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır.");
            }else {
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                System.out.println("Eski silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public void printArmor(){
        System.out.println("Zırhlar");
    }

}
