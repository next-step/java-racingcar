package racingcar.model;

import java.util.Scanner;

public class InputView {
    private final int carCount;
    private final int tryCount;

    private static final String HOW_MANY_CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String HOW_MANY_TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";

    public int carCount() {
        return carCount;
    }

    public int tryCount() {
        return tryCount;
    }

    public InputView(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public static InputView scan() {
        System.out.println(HOW_MANY_CAR_QUESTION);
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println(HOW_MANY_TRY_QUESTION);
        int tryCount = Integer.parseInt(scanner.nextLine());

        return new InputView(carCount, tryCount);
    }
}
