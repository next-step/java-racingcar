package racingcarGame.client;

import java.util.Scanner;

import static racingcarGame.client.ResultView.show;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int scanCarCount() {
        show("자동차 대수는 몇대 인가요?");
        return input();
    }
    public static int scanPlayCount() {
        show("시도할 회수는 몇 회 인가요?");
        return input();
    }

    private static int input() {
        return scanner.nextInt();
    }
}
