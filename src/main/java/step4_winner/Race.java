package step4_winner;


import lombok.Getter;

import java.util.List;
import java.util.Random;

public class Race {
    private final Random random = new Random();
    @Getter private final List<Car> cars;
    @Getter private final int tries;

    public Race(List<Car> cars, int tries) {
        if (cars.isEmpty())
            throw new IllegalArgumentException("0이상이어야 함");
        this.cars = cars;
        this.tries = tries;
    }

    public void runRound() {
        cars.forEach(car -> car.move(random.nextInt(10)));
    }
}
