package racingcargame.ui;

import java.util.Scanner;

public class InputView extends AbstractView {
    private final String readCarCountMessage = "자동차 대수는 몇 대 인가요?";
    private final String readTryCountMessage = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public int readCarCount() {
        print(readCarCountMessage);
        return scanner.nextInt();
    }

    public int readTryCount() {
        print(readTryCountMessage);
        return scanner.nextInt();
    }
}
