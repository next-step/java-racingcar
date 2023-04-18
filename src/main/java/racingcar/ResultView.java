package racingcar;

import java.util.List;

public class ResultView {
    private static final String MOVE = "-";

    public static void racingView(List<Car> cars) {
        for (final Car car : cars) {
            move(car.getMoveCount());
            next();
        }
        next();
    }

    private static void move(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(MOVE);
        }
    }

    private static void next() {
        System.out.println();
    }
}
