package racingcar.module;

import java.util.Scanner;

public class IntScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static int insertCarCount() {
        InputView.showInsertCarCountPhrase();
        return scanner.nextInt();
    }

    public static int insertRaceCount() {
        InputView.showInsertRaceCountPhrase();
        return scanner.nextInt();
    }
}
