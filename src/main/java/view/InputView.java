package view;
import java.util.Scanner;

public final class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static String getCarNames(String message) {
        displayMessage(message);
        return SCANNER.nextLine();
    }

    public static int getRounds(String message) {
        displayMessage(message);
        return SCANNER.nextInt();
    }
}
