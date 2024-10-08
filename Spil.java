import java.util.Random;
import java.util.Scanner;

class Spil {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        
        //læser fra konsol spillerens navn
        Player player1 = new Player();
        System.out.print("Enter your name ");
        player1.name = scanner.nextLine();


        //læser fra konsol spillerenes navn
        Player player2 = new Player();
        System.out.print("Enter your name ");
        player2.name = scanner.nextLine();



        System.out.println("Hello " + player1 + " and " + player2 + ". Enjoy your game!");


    


        //kode for at spillerne skifter tur
        boolean game = true;
        int targetpoints = 40; 
        

        while (game) {
            for (Player Current : new Player[]{player1, player2}) {
            System.out.println(Current.name + "'s turn. press enter to roll the dice");
            scanner.nextLine();



             //her lægges spillerens nuværende point sammen med de point han får i den specifikke runde spilleren er nået til.
            int[] rolls = Terninger.roll();
            if (rolls[0] == 1 && rolls[1] == 1) {
                Current.points = 0;

            } else {
            int roundPoints = rolls[0] + rolls[1];
            Current.points += roundPoints;
            System.out.println(Current.name + " rolled: " + rolls[0] + " and " + rolls[1] + ". Total points: " + Current.points);
            }


            if (Current.points >= targetpoints && rolls[0] == rolls[1]) {
                System.out.println(Current.name + " wins with " + Current.points + " points!");
                game = false; 
                break; 
            }
            }



        } 
    }
}






class Player {
    String name;
    int points;
        // dette gør sådan at den rent faktisk printer hvad vi skriver i consollen.
        public String toString() {
            return name;
        }
        int resetPoint() {
            return 0;
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
