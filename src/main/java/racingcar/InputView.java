package racingcar;
import java.util.Scanner;

public final class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static int getUserInput() {
        return scanner.nextInt();
    }

    public static String getStringInput() {
        return scanner.nextLine();
    }
}
