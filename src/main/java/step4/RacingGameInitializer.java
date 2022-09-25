package step4;

import java.util.Scanner;

public class RacingGameInitializer {

    private static final Scanner SCANNER = new Scanner(System.in);

    private RacingGameInitializer() {
    }

    public static int initTryCount() {
        RacingGamePrinter.printInitTryCountPhrase();
        int tryCount = SCANNER.nextInt();
        validateOneLessThen(tryCount);
        return tryCount;
    }

    public static String[] initRacingCarNames() {
        RacingGamePrinter.printInitRacingCarPhrase();
        String inputLine = SCANNER.next();
        return inputLine.split(",");
    }

    private static void validateOneLessThen(int i) {
        if (i <= 0) {
            throw new RuntimeException("1보다 작은 숫자를 허용하지 않습니다.");
        }
    }
}
