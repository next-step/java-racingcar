package step5.view;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MANY_CYCLE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_ROUND = 0;
    private static final int MIN_CAR = 0;
    private static final String CYCLE_ERROR_MESSAGE = "시도할 횟수는 0보다 커야 합니다.";
    private static final String CAR_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";
    private static final Scanner sc = new Scanner(System.in);

    public String requestCars() {
        System.out.println(HOW_MANY_CAR);
        return sc.next();
    }

    public int requestRound() {
        System.out.println(HOW_MANY_CYCLE);
        return sc.nextInt();
    }
}
