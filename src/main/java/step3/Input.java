package step3;

import java.util.Scanner;

public class Input {

    private static Scanner scanner;

    public static int setCarsCount() {
        // input
        System.out.println("How many cars into this game? : ");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int setPlayCounts() {
        // input
        System.out.println("How many times try this game? : ");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
