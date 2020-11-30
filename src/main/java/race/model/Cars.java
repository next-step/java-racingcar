package race.model;

import race.strategy.RandomMoveStrategy;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars(int carNumber) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        cars = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(randomMoveStrategy));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
