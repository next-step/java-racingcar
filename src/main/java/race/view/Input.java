package race.view;

import java.util.List;
import java.util.Scanner;

public final class Input {

    public static final String DELIMITER_FOR_INPUT = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPlayCount() {
        return SCANNER.nextInt();
    }

    public static List<String> getCarName() {
        return List.of(SCANNER.nextLine().split(DELIMITER_FOR_INPUT));
    }
}
