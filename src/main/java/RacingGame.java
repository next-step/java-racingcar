import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int attempts;

    public RacingGame(int carCount, int attempts, MovementCondition movementCondition) {
        this.cars = IntStream.range(0, carCount)
                .mapToObj(i -> new RacingCar(movementCondition))
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public void run() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
