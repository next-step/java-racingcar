package racingcar;
import java.util.Scanner;

public final class InputView {
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
