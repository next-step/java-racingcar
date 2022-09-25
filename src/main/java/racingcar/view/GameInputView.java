package racingcar.view;

import java.util.Scanner;

import racingcar.domain.Racing;

public class GameInputView {
    private final Scanner input;

    public GameInputView(Scanner input) {
        this.input = input;
    }

    public Racing racing() {
        return Racing.of(carCount(), tryCount());
    }

    private int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return input.nextInt();
    }

    private int tryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return input.nextInt();
    }
}
