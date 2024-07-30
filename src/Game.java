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




    }
}
