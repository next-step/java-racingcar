package racing.ui;

import racing.view.RacingRequestView;

import java.util.Scanner;

public class GameReady {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_GAME_COUNT = "시도할 회수는 몇 회 인가요?";

    public static RacingRequestView set() {
        Scanner scanner = new Scanner(System.in);

        String carNames = setCarNames(scanner);

        int gameCount = setGameCount(scanner);

        scanner.close();
        return new RacingRequestView(carNames, gameCount);
    }

    private static int setGameCount(Scanner scanner) {
        System.out.println(QUESTION_GAME_COUNT);
        return scanner.nextInt();
    }

    private static String setCarNames(Scanner scanner) {
        System.out.println(QUESTION_CAR_NAMES);
        return scanner.nextLine();
    }

}
