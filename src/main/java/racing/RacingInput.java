package racing;

import java.util.Scanner;

public class RacingInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int input(RacingInputType racingInputType) {
        System.out.println(racingInputType.getMessage());
        return scanner.nextInt();
    }
}
