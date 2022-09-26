package ThirdStep;

import java.util.Scanner;

public class UserInputScanner {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int intScan() {
        return SCANNER.nextInt();
    }

    public static String stringScan() {
        return SCANNER.nextLine();
    }
}
