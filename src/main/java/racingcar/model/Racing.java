package racingcar.model;

import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();


    public void start(List<Car> cars) {
        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
            ResultView.printCarMovement(car);
        }
        System.out.println();
    }
}
