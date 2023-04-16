package step3;

import java.util.Random;

public class Racing {

    private final int carCount;
    private final Car[] cars;

    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM_BOX = new Random();

    public Racing(int carCount) {
        validation(carCount);
        this.carCount = carCount;
        this.cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public static void validation(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }

    public static boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }

    public void run() {
        for (int i = 0; i < carCount; i++) {
            if (canMove(RANDOM_BOX.nextInt(RANDOM_BOUND))) {
                cars[i].move();
            }
        }
    }

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int moveCount = InputView.inputMoveCount();
        validation(moveCount);
        Racing racingGame = new Racing(carCount);

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            racingGame.run();
            OutputView.printCarPosition(racingGame.cars);
        }
    }
}
