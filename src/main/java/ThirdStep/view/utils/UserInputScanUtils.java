package ThirdStep.view.utils;

import java.util.Scanner;

public class UserInputScanUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int intScan() {
        return SCANNER.nextInt();
    }

    public static String stringScan() {
        return SCANNER.nextLine();
    }
}
