package racing;

import java.util.Scanner;

public class RacingInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(RacingInputType racingInputType) {
        System.out.println(racingInputType.getMessage());
        return scanner.nextInt();
    }

    public static String inputString(RacingInputType racingInputType) {
        System.out.println(racingInputType.getMessage());
        return scanner.nextLine();
    }
}
