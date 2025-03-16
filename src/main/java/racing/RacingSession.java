package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    public static final int MIN_PROGRESS_NUMBER = 4;

    private final List<Car> cars;
    private List<List<Integer>> lastPlayHistory;

    private RacingSession(List<Car> cars){
        this.cars = cars;
    }

    public static RacingSession of(String carNames){
        List<Car> cars = Car.createCars(carNames);
        return new RacingSession(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<List<Integer>> startRacing(int turns){
        List<List<Integer>> totalPositions = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            totalPositions.add(moveCars(cars));
        }
        this.lastPlayHistory = totalPositions;
        return totalPositions;
    }

    public static List<Integer> moveCars(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(canProgress(getRandom())));
        }
        return positions;
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean canProgress(int number) {
        return number >= MIN_PROGRESS_NUMBER;
    }
}
