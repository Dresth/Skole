import java.util.Random;
import java.util.Scanner;

class 28_del1 {
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

        System.out.println("Hello " + player1 + " and " + player2 + ". Enjoy your game!");


        
        boolean game = true;
        int targetpoints = 40; 
        boolean prevroll = false;

        

        // while loop er hele spillet fra start til slut
        while (game) {
            
            //Ny variable går igennem array og bruges til at holde styr på tur og point
            for (Player CurrentPlayer : new Player[]{player1, player2}) {
                boolean doubleroll = true;
                while (doubleroll) {
                
            System.out.println(CurrentPlayer.name + "'s turn. Press enter to roll the dice");
            scanner.nextLine();



             //her lægges spillerens nuværende point sammen med de point han får i den specifikke runde spilleren er nået til.
            int[] rolls = Terninger.roll();
            if (rolls[0] == 1 && rolls[1] == 1) {
                CurrentPlayer.points = 0;
                System.out.println(CurrentPlayer.name + " rolled: " + rolls[0] + " and " + rolls[1] + ". Your points have been reset. Your points: " + CurrentPlayer.points);
                doubleroll = false; 


            } else {
            int roundPoints = rolls[0] + rolls[1];
            CurrentPlayer.points += roundPoints;
            System.out.println(CurrentPlayer.name + " rolled: " + rolls[0] + " and " + rolls[1] + ". Total points: " + CurrentPlayer.points);
            } 
           

            
            //Her vises kode for at vinde med to 6'ere
            if (rolls[0] == 6 && rolls[1] == 6){
                
            if (prevroll) {
                System.out.println("YOU WIN!!!");
                game = false; 
                doubleroll = false; 
                break; 
              
            }  else {
                prevroll = true; 

            } 
            } else {
                prevroll = false; 
            }  

            

                //Her er vores logik for at hvis en af spillerens point når over 40, og de har slået to ens, vinder spilleren. 
            if (CurrentPlayer.points >= targetpoints && rolls[0] == rolls[1]) {
                System.out.println(CurrentPlayer.name + " wins with " + CurrentPlayer.points + " points!");
                game = false; 
                doubleroll = false; 
                break; 
            } 



            //Her har vi skrevet kode for når en spiller roller to ens
            if (rolls[0] == rolls[1]) {
                System.out.println("You rolled the same number twice! Roll again.");
                doubleroll = true; // Continue rolling
            } else {
                doubleroll = false; // End the turn if they don't roll the same number
            }



            //Her afsluttes spiller for double double 6 win condition
            if (!game) {
                break;
                }
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
