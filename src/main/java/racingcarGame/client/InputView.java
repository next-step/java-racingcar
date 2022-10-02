package racingcarGame.client;

import java.util.Scanner;

import static racingcarGame.client.ResultView.show;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_REGEX = ",";

    public static String[] scanCars() {
        show("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(DEFAULT_REGEX);
    }

    public static int scanPlayCount() {
        show("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
