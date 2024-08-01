import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Survivor oyununa hoş geldiniz");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println();
        System.out.println( "Sayın "+ player.getName() + " bu karanlık ve sisli adaya hoşgeldin ! Burada yaşananların hepsi gerçek !");
        System.out.println();
        System.out.println("Maceraya başlamak için bir karakter seçmelisin! " );
        System.out.println("Bir ID gir : ");
        player.selectChar();
        Location location = null;

        while(true){
            player.printInfo();
            System.out.println("Bölgeler: ");
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yok!");
            System.out.println("2 - Mağaza --> Silah veya Zırh satın alabilirsiniz!");
            System.out.println();
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }





    }
}
