package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int initTryCount() {
        PrintView.printInitTryCountPhrase();
        int tryCount = SCANNER.nextInt();
        validateOneLessThen(tryCount);
        return tryCount;
    }

    public static String[] initRacingCarNames() {
        PrintView.printInitRacingCarPhrase();
        String inputLine = SCANNER.next();
        return inputLine.split(",");
    }

    private static void validateOneLessThen(int num) {
        if (num <= 0) {
            throw new RuntimeException("1보다 작은 숫자를 허용하지 않습니다. | 입력된 숫자: " + num);
        }
    }
}