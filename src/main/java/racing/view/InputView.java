package racing.view;

import java.util.Scanner;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int askInteger(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }

    public static String askString(String message) {
        System.out.println(message);
        return SCANNER.next();
    }
}
