package step3.controller;

import step3.RacingSpec;

import java.util.Scanner;

public class InputController {

    private final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    public RacingSpec enterInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CAR_COUNT_QUESTION);
        int carCount = scanner.nextInt();
        System.out.println(MOVE_COUNT_QUESTION);
        int moveCount = scanner.nextInt();
        RacingSpec spec = new RacingSpec(carCount, moveCount);
        return spec;
    }

}
