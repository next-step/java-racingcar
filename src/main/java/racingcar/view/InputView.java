package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final int carCount;

    private final int moveCount;

    private InputView(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public static InputView input() {
        return new InputView(inputCarCount(), inputMoveCount());
    }

    private static int inputCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임에서 진행할 자동차의 수 : ");

        return scanner.nextInt();
    }

    private static int inputMoveCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차의 이동 횟수(게임 횟수) : ");

        return scanner.nextInt();
    }

    public int carCount() {
        return carCount;
    }

    public int moveCount() {
        return moveCount;
    }
}
