public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz!");
        boolean showMenu = true;
       while(showMenu) {
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
                   break;
               case 2 :
                   printArmor();
                   buyArmor();
                   break;
               case 3 :
                   System.out.println("Görüşmek üzere!!");
                   showMenu = false;
                   break;
           }
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
        while(selectWeapon < 0 || selectWeapon > Weapon.weapons().length ){
            System.out.println("Geçersiz değer , tekrar giriniz : ");
            selectWeapon = input.nextInt();
        }

        if (selectWeapon != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeapon);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                    System.out.println("Eski Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("Zırhlar");
        for (Armor a : Armor.armors()) {
            System.out.println( a.getId() +"-"+ a.getName() +
                    " < Para : " + a.getPrice() +
                    ", Zırh : " + a.getBlock() + " >");
        }
    }

    public void buyArmor(){
        System.out.println("Bir zırh seçiniz : ");
        int selectArmorID = input.nextInt();
        while(selectArmorID < 0 || selectArmorID > Armor.armors().length ){
            System.out.println("Geçersiz değer , tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                }else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                    System.out.println("Eski Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }




}
