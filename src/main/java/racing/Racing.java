package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    final private List<Round> rounds;
    final private List<Car> cars;
    final private int attemptsCount;

    private Racing(int attemptsCount) {
        this.rounds = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.attemptsCount = attemptsCount;
    }

    public Racing(int carsCount, int attemptsCount) {
        this(attemptsCount);
        for (int i = 0; i < carsCount; i++) {
            cars.add(new Car());
        }
    }

    public Racing(String[] carNames, int attemptsCount) {
        this(attemptsCount);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void runRace() {
        tryMoveCars();
        rounds.add(Round.createFrom(cars));
    }

    private void tryMoveCars() {
        for (Car car : cars) {
            car.tryMove(() -> RandomUtil.nextInt(Car.MAX_BOUNDARY_VALUE + 1));
        }
    }

    public boolean hasNext() {
        return rounds.size() < attemptsCount;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}

