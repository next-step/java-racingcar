package step3.view.input;

import java.util.Scanner;

public class InputScanner {

    public static int scanIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String scanStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
