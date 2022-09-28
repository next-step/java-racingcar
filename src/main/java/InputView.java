import java.util.Scanner;

public class InputView {

    public static int inputNumber(Scanner scanner, String msg) {
        System.out.println(msg);

        return scanner.nextInt();
    }
}
