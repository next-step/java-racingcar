package racing.domain;

import racing.util.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars() {
        this.carList = new ArrayList<>();
    }

    public RacingCars(int carCount) {
        this();
        joinCars(carCount);
    }

    public List<Integer> carsMove() {
        return carList.stream().map(car -> car.move(Dice.cast())).collect(Collectors.toList());
    }

    private void joinCars(int carCount) {
        for (int i = 0 ; i < carCount ; i++) {
            carList.add(new Car());
        }
    }
}
