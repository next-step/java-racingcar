package racingcar3.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(int numberOfCars) {
        this.cars = new ArrayList<>(numberOfCars);
        for (int cnt=0; cnt < numberOfCars; cnt++) {
            cars.add(new Car());
        }
    }

    public void oneTurn() {
        for (Car car:cars) {
            car.carTurn();
        }
    }

    public int[] getCarsPosition() {
        int[] carsPosition = new int[cars.size()];

        for (int cnt=0; cnt < cars.size(); cnt++) {
            carsPosition[cnt] = cars.get(cnt).getPosition();
        }

        return carsPosition;
    }
}
