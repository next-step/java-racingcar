package racingcargame;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> cars;
    private int car, count = 0;

    RacingCarGame(int car, int count) {
        this.car = car;
        this.count = count;
        cars = createCars(car);
    }

    public List<RacingCar> createCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }

    public void startGame(final RandomOption randomOption) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < car; j++) {
                cars.get(j).tryToMoveCar(randomOption.randomValue());
            }
            System.out.println();
        }
    }
}