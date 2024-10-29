import java.util.Random;
import java.util.Scanner;

class spil {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        
        //Læser fra konsol spillerens navn
        Player player1 = new Player();
        System.out.print("Enter your name ");
        player1.name = scanner.nextLine();


        //Læser fra konsol spillerenes navn
        Player player2 = new Player();
        System.out.print("Enter your name ");
        player2.name = scanner.nextLine();

        System.out.println("Hello " + player1 + " and " + player2);

        System.out.println("Each player starts with 1000$ Dollars");
        System.out.println("To win the game, one player needs to optain 3000$ ");
        System.out.println("Enjoy your game!");
        boolean game = true;
        int targetpoints = 3000; 
        int test = 1000;
        // while loop er hele spillet fra start til slut
        

        while (game) {
            
            //Ny variable går igennem array og bruges til at holde styr på tur og point
            for (Player CurrentPlayer : new Player[]{player1, player2}) {
                
                
            System.out.println(CurrentPlayer.name + "'s turn. Press enter to roll the dice");
            scanner.nextLine();



             //her lægges spillerens nuværende point sammen med de point han får i den specifikke runde spilleren er nået til.
            int[] rolls = Terninger.roll();
            int sum = rolls[0] + rolls[1];
            int change = 0;

            if (sum == 2) {
                System.out.println("You rolled a 2 and landed on [Tower] which grants you 250$ Dollars");
                change = 250;
                
            } 
            if (sum == 3) {
                System.out.println("You rolled a 3 and landed on [Crater] which means you have to pay 100$ Dollars");
                change = -100; 

            }if (sum == 4) {
                System.out.println("You rolled a 4 and landed on [Palace gates] which grants you 100$ Dollars");
                change = 100;

            }if (sum == 5) {
                System.out.println("You rolled a 5 and landed on [Cold Desert] which means you have to pay 20$ Dollars");
                change = -20;

            }if (sum == 6) {
                System.out.println("You rolled a 6 and landed on [Walled city] which grants you 180$ Dollars");
                change = 180;

            }if (sum == 7) {
                System.out.println("You rolled a 7 and landed on [Monestary] which means you gain nothing");
                change = 0;

            }if (sum == 8) {
                System.out.println("You rolled a 8 and landed on [Black cave] which means you have to pay 70$ Dollars");
                change = -70;

            }if (sum == 9) {
                System.out.println("You rolled a 9 and landed on [Huts in the mountain] which grants you 60$ Dollars");
                change = 60;

            }if (sum == 10) {
                System.out.println("You rolled a 10 and landed on [The Werewall] which means you have to pay 80$ Dollars, but you get to roll again!");
                change = -80;

            }if (sum == 11) {
                System.out.println("You rolled a 11 and landed on [The pit] which means you have to pay 50$ Dollars");
                change = -50;

            }if (sum == 12) {
                System.out.println("You rolled a 12 and landed on [Goldmine] which grants you 650$ Dollars");
                change = 650;
            }
            CurrentPlayer.updatePoints(change);
            System.out.println(CurrentPlayer.name +" currently has " + CurrentPlayer.points + "$ Dollars");
            int remainingPoints = targetpoints - CurrentPlayer.points;
            System.out.println(CurrentPlayer.name + " needs "  +remainingPoints + "$ Dollars to win the game");


            


                //Her er vores logik for at hvis en af spillerens point når over 40, og de har slået to ens, vinder spilleren. 
            if (CurrentPlayer.points >= targetpoints ) {
                System.out.println(CurrentPlayer.name + " wins with " + CurrentPlayer.points + " points!");
                game = false; 
                break; 
            } 
            //Her afsluttes spillet for den normale win condition
                if (!game) {
                    break;
                }
            } 
            //Her asluttes spillet 
            if (!game) {
                break; 
            }
        }

    }
}




class Player {
    String name;
    int points=1000;

        // dette gør sådan at den rent faktisk printer hvad vi skriver i consollen.
        public String toString() {
            return name;
        }
        public void updatePoints(int change) {
            points+= change;
            if (points< 0) {
                points = 0; //for at sikre sig den mindste værdi er 0
                
            }
            if (points >3000) {
                points = 3000;
                
            }
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
