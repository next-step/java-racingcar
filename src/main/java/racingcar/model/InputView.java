package racingcar.model;

import java.util.Scanner;

public class InputView {
    private final int carCount;
    private final int tryCount;

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
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = Integer.parseInt(scanner.nextLine());

        return new InputView(carCount, tryCount);
    }
}
