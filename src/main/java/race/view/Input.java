package race.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPlayCount() {
        return SCANNER.nextInt();
    }

    public static List<String> getCarName() {
        return Arrays.asList(SCANNER.nextLine().split(","));
    }
}
