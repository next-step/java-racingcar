package racingcar;

import java.util.Scanner;

public class InputView {

    public static int requestInputCount() {
        ResultView.println("자동차 대 수는 몇 대 인가요?");
        return scanNumber();
    }

    public static int requestInputRepeat() {
        ResultView.println("시도할 회수는 몇 회 인가요?");
        return scanNumber();
    }

    private static int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
