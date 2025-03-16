package racinggame;

import java.util.List;

public class Race {

    private final List<Car> carList;
    private final RandomGenerator randomGenerator;

    public Race(final List<Car> carList) {
        this(carList, new RacingRandomGenerator());
    }

    public Race(final List<Car> carList, final RandomGenerator randomGenerator) {
        this.carList = carList;
        this.randomGenerator = randomGenerator;
    }

    public List<Car> cars() {
        return this.carList;
    }

    public void run(final int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        carList.forEach(car -> car.move(randomGenerator.nextInt()));
    }
}
