import java.util.Random;
import java.util.Scanner;

class Spil {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        scan.useLocale(java.util.Locale.ENGLISH);

    }
}


class Player {
    
}

class Terninger {
    private static Random random = new Random();

    public static int[] roll() {
        int roll1 = random.nextInt(6) + 1; // Slå terning 1
        int roll2 = random.nextInt(6) + 1; // Slå terning 2
        return new int[]{roll1, roll2};
    }
}
