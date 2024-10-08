package racingcar.model;

import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    public CarManager ready(String names) {
        return CarManager.createCars(names);
    }

    public void game(CarManager carManager, int count) {
        for (int i = 0; i < count; i++) {
            moveCar(carManager.getCars());
        }

        ResultView.printWinner(carManager.findWinner());
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
        }

        ResultView.print(cars);
    }

}
