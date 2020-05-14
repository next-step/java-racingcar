package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final int carCount;
    private final int moveCount;

    public InputView(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public static InputView create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new InputView(carCount, moveCount);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
