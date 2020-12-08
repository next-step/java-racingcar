package racingcar.view;

import racingcar.Car;
import racingcar.RandomGenerator;

import java.util.List;

public class ResultView {
    private static final String MOVE_COUNT_VIEW = "-";

    public void resultRacing(List<Car> cars) {
        for (Car car : cars) {
            moveCarView(car);
        }
        System.out.println();
    }

    public void moveCarView(Car car) {
        RandomGenerator generator = new RandomGenerator();
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(MOVE_COUNT_VIEW);
        }
        car.setLocation(generator.getRandom());
        System.out.println();
    }
}
