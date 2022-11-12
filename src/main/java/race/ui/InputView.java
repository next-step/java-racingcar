package race.ui;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPlayCount() {
        return SCANNER.nextInt();
    }

    public static String[] getCarName() {
        return SCANNER.nextLine().split(",");
    }
}
