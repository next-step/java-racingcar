import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private static final int MOVEMENT_THRESHOLD = 4;
    private final int totalRounds;
    private final List<Car> cars;
    private int currentRound = 0;

    public Race(int carCount, int totalRounds) {
        if (carCount < 1 || totalRounds < 1) {
            throw new IllegalArgumentException();
        }

        this.totalRounds = totalRounds;
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Integer> getCarPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public void runRound() {
        if (isRaceFinished()) {
            throw new IllegalStateException("Race has already finished");
        }

        for (Car car : cars) {
            moveCar(car, random.nextInt(10));
        }
        currentRound++;
    }

    public boolean isRaceFinished() {
        return currentRound >= totalRounds;
    }

    public void moveCar(Car car, int seed) {
        if (seed < 0 || seed > 9) {
            throw new IllegalArgumentException("Invalid seed: " + seed);
        }

        if (seed >= MOVEMENT_THRESHOLD) {
            car.move();
        }
    }
}
