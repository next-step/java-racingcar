package racing;

import java.util.*;

public class Racing {

    private Racing() {
        throw new AssertionError();
    }

    public static ArrayList<Car> racing(int carCount, int moveCount) {
        if (carCount <= 0 || moveCount <= 0) {
            throw new IllegalArgumentException("입력값으로 0이나 음수를 넣을 수 없습니다.");
        }

        OutputView.printStartLine();

        ArrayList<Car> cars = Car.initCars(carCount);

        for (int i = 0; i < moveCount; i++) {
            OutputView.render(Car.moveCars(cars));
        }

        return cars;
    }
}
