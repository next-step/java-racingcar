package racingcar;

import java.util.Scanner;

public class RacingGameInitializer {

    private final static Scanner SCANNER = new Scanner(System.in);

    private RacingGameInitializer() {}

    public static int initTryCount() {
        RacingGamePrinter.printInitTryCountPhrase();
        int tryCount = SCANNER.nextInt();
        validateOneLessThen(tryCount);
        return tryCount;
    }

    public static int initRacingCarCount() {
        RacingGamePrinter.printInitCarCountPhrase();
        int racingCarCount = SCANNER.nextInt();
        validateOneLessThen(racingCarCount);
        return racingCarCount;
    }

    private static void validateOneLessThen(int i) {
        if (i <= 0) {
            throw new RuntimeException("1보다 작은 숫자를 허용하지 않습니다.");
        }
    }
}
