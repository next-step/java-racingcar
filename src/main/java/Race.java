import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private final int totalRounds;
    private final List<Car> cars;
    private int currentRound = 0;

    public Race(GameSettings settings) {
        if (settings.getCarCount() < 1 || settings.getRoundCount() < 1) {
            throw new IllegalArgumentException("Invalid game settings: " + settings);
        }

        this.totalRounds = settings.getRoundCount();
        this.cars = new ArrayList<>();
        for (int i = 0; i < settings.getCarCount(); i++) {
            this.cars.add(new Car());
        }
    }

    public List<CarStatus> getCarStatuses() {
        List<CarStatus> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(new CarStatus(car));
        }
        return statuses;
    }

    public void runRound() {
        if (!isRaceInProgress()) {
            throw new IllegalStateException("Race has already finished");
        }

        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
        currentRound++;
    }

    public boolean isRaceInProgress() {
        return currentRound < totalRounds;
    }
}
