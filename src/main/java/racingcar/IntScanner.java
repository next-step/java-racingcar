package racingcar;

import java.util.Scanner;
import racingcar.view.InputView;

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
