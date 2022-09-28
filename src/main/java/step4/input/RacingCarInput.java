package step4.input;

import java.util.Scanner;

public class RacingCarInput {

    private static final String CAR_NAME_DELIMITER = ",";

    public static String[] carNames() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(CAR_NAME_DELIMITER);
    }

    public static int tryCount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
