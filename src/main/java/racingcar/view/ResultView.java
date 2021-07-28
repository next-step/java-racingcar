package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;

public class ResultView {
    private static final String INDICATION = "-";

    public static void print(Cars cars) {
        for (Car car : cars.getCars()) {
            Position position = car.getPosition();
            print(position.getPosition());
        }
        System.out.println();
    }

    private static void print(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(INDICATION);
        }
        System.out.println();
    }
}
