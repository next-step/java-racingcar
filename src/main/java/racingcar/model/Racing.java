package racingcar.model;

import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    public Garage ready(String names) {
        return Garage.createCars(names);
    }

    public void game(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            moveCar(cars);
            ResultView.print(cars);
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
        }
    }

}
