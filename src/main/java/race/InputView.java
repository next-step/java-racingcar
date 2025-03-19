package race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberInput(String msg) {
        System.out.print(msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return -1;
    }
}
