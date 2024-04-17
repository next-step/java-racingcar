package step4_winner.domain;


import lombok.Getter;

import java.util.List;
import java.util.Random;

public class Race {
    private final Random random = new Random();
    @Getter private final List<Car> cars;

    public Race(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException("0이상이어야 함");
        this.cars = cars;
    }

    public void runRace() {
        cars.forEach(car -> car.move(random.nextInt(10)));
    }
}
