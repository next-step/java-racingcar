package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static Cars cars;
    private final RandomMove randomMove;

    public RacingCar(int numCars, RandomMove randomMove) {
        this.cars = carReady(numCars);
        this.randomMove = randomMove;
    }

    public void racingPlay() {
        cars.move(randomMove);
    }

    public Cars carReady(final int numCars) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < numCars; i++) {
            cars.add(new Car());
        }

        return new Cars(cars);
    }

    public List<Car> getCarList() {
        return cars.getCar();
    }

}
