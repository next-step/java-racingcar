package game;

import java.util.Scanner;

public final class InputView {

    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String RACING_REP_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static RacingOptions showAndGetOptions() {
        Scanner sc = new Scanner(System.in);

        System.out.println(CAR_COUNT_QUESTION);
        int carCount = sc.nextInt();

        System.out.println(RACING_REP_COUNT_QUESTION);
        int repCount = sc.nextInt();

        return new RacingOptions(carCount, repCount);
    }
}