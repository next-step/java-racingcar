package racingcar;

import java.util.Scanner;

public class RacingGameInitializer {

    private static Scanner scanner = new Scanner(System.in);

    public static int initTryCount() {
        RacingGamePrinter.printInitTryCountPhrase();
        int tryCount = scanner.nextInt();
        validateOneLessThen(tryCount);
        return tryCount;
    }

    public static int initRacingCarCount() {
        RacingGamePrinter.printInitCarCountPhrase();
        int racingCarCount = scanner.nextInt();
        validateOneLessThen(racingCarCount);
        return racingCarCount;
    }

    private static void validateOneLessThen(int i) {
        if (i <= 0) {
            throw new RuntimeException("1보다 작은 숫자를 허용하지 않습니다.");
        }
    }
}
