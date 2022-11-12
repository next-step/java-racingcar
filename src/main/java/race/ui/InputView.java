package race.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPlayCount() {
        return SCANNER.nextInt();
    }

    public static List<String> getCarName() {
        return Arrays.asList(SCANNER.nextLine().split(","));
    }
}
