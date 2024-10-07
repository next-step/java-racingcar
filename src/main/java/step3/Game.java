package step3;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void play(int carCount, int gameCount) {

        Cars cars = new Cars(makeRacingCars(carCount));

        for (int i = 0; i < gameCount; i++) {
            moveAndSaveResult(cars, i);
        }

    }

    private void moveAndSaveResult(Cars cars, int i) {
        for (Car car : cars.getCars()) {
            car.move(new RandomMoveStrategy());
        }
    }

    private List<Car> makeRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
