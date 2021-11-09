package carracing.util;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
    }

    public static Integer getInputInteger(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }

    public static String getInputString(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

}
