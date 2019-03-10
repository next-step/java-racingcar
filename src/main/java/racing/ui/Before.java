package racing.ui;

import racing.view.RacingRequestView;

import java.util.Scanner;

public class Before {
    private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_GAME_COUNT = "시도할 회수는 몇 회 인가요?";

    public static RacingRequestView set() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_CAR_COUNT);
        int carCount = scanner.nextInt();

        System.out.println(QUESTION_GAME_COUNT);
        int gameCount = scanner.nextInt();

        scanner.close();
        return new RacingRequestView(carCount, gameCount);
    }
}
