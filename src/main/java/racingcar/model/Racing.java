package racingcar.model;

import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    public Garage ready(String names) {
        return Garage.createCars(names);
    }

    public void game(Garage garage, int count) {
        for (int i = 0; i < count; i++) {
            moveCar(garage.getCars());
            ResultView.print(garage);
        }

        ResultView.printWinner(garage);
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
        }
    }

}
