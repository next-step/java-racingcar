package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    final private List<Round> rounds;
    final private List<Car> cars;
    final private int attemptsCount;

    public Racing(int carsCount, int attemptsCount) {
        this.rounds = new ArrayList<>();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            this.cars.add(new Car());

        }
        this.attemptsCount = attemptsCount;
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

