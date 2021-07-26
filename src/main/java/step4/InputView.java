package step4;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CAR = "자동차의 대수는 몇 대 인가요?";
    private static final String HOW_MANY_CYCLE = "시도할 횟수는 몇 회 인가요?";
    private static final int MIN_ROUND = 0;
    private static final int MIN_CAR = 0;
    private static final String CYCLE_ERROR_MESSAGE = "시도할 횟수는 0보다 커야 합니다.";
    private static final String CAR_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";
    private Scanner sc = new Scanner(System.in);

    public int getNumOfCar() {
        System.out.println(HOW_MANY_CAR);
        return getInput();
    }

    public int getNumOfCycle() {
        System.out.println(HOW_MANY_CYCLE);
        return getInput();
    }

    private int getInput() {
        return sc.nextInt();
    }

    public void inputCarCheck(int numOfCar) {
        if (numOfCar <= MIN_CAR) {
            throw new IllegalArgumentException(CAR_ERROR_MESSAGE);
        }
    }

    public void inputRoundCheck(int numOfCycle) {
        if (numOfCycle <= MIN_ROUND) {
            throw new IllegalArgumentException(CYCLE_ERROR_MESSAGE);
        }
    }
}
