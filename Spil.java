import java.util.Random;
import java.util.Scanner;

class Spil {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        scan.useLocale(java.util.Locale.ENGLISH);




        // Opretter spillere
        System.out.print("Indtast navn på spiller 1: ");
        String name1 = scan.nextLine();
        Player player1 = new Player(name1);

        System.out.print("Indtast navn på spiller 2: ");
        String name2 = scan.nextLine();
        Player player2 = new Player(name2);




        // Spillets hovedloop
        while (player1.getPoints() < 40 && player2.getPoints() < 40) {
            playTurn(player1, scan);
            if (player1.getPoints() >= 40) break;
            playTurn(player2, scan);
        }




        // Bestem vinderen
        if (player1.getPoints() >= 40) {
            System.out.println(player1.getName() + " vinder!");
        } else {
            System.out.println(player2.getName() + " vinder!");
        }
    }




    private static void playTurn(Player player, Scanner scan) {
        int roll1, roll2;
        do {
            System.out.println(player.getName() + "'s tur. Tryk enter for at kaste terningerne.");
            scan.nextLine();
            int[] rolls = Terninger.roll();
            roll1 = rolls[0];
            roll2 = rolls[1];
            System.out.println("Du slog: " + roll1 + " og " + roll2);


            // Tjek for ekstra regler
            if (roll1 == 1 && roll2 == 1) {
                System.out.println("Du slog to 1'ere! Alle dine point går tabt.");
                player.resetPoints();
                break;
            } else {
                player.addPoints(roll1 + roll2);
                System.out.println(player.getName() + " har nu " + player.getPoints() + " point.");
            }


            // Tjek for ekstra tur ved ens
            if (roll1 == roll2) {
                System.out.println("Du slog to ens! Du får en ekstra tur.");
            } else {
                break; // Afslut turen hvis ikke to ens
            }
        } while (true); // Fortsæt så længe spilleren slår to ens


    }
}

class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }
}



class Terninger {
    private static Random random = new Random();

    public static int[] roll() {
        int roll1 = random.nextInt(6) + 1; // Slå terning 1
        int roll2 = random.nextInt(6) + 1; // Slå terning 2
        return new int[]{roll1, roll2};
    }
}