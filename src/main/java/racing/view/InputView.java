package racing.view;

import racing.domain.RacingGameInfo;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public RacingGameInfo setInfo() {
        return new RacingGameInfo(inputCarCount(), inputTryCount());
    }

    public static String inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public String inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }
}
