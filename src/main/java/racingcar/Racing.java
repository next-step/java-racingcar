package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static final int POWER_BOUND = 9;

    private static final Random random = new Random();
    private static List<Car> cars;
    private static int raceCount;
    private static List<List<Car>> raceResults;

    public static void main(String[] args) {
        Racing.setRace(InputView.askCarCount(null), InputView.askRaceCount(null));
        Racing.startRace();
        OutputView.endRace();
    }

    public static void setRace(int carCount, int raceCount) {
        setCars(carCount);
        setRaceCount(raceCount);
        setRaceResults();
    }

    private static void setRaceResults() {
        raceResults = new ArrayList<>();
    }

    private static void setRaceCount(int raceCount) {
        Racing.raceCount = raceCount;
    }

    private static void setCars(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public static void startRace() {
        for (int r = 0; r < raceCount; r++) {
            raceCars();
            saveRaceResult();
        }
    }

    private static void raceCars() {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            raceCar(cars.get(i), getNextInt());
        }
    }

    private static void saveRaceResult() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.clone());
        }
        raceResults.add(result);
    }

    private static void raceCar(Car car, int power) {
        car.move(power);
    }

    private static int getNextInt() {
        return random.nextInt(POWER_BOUND + 1);
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static int getRaceCount() {
        return raceCount;
    }

    public static List<List<Car>> getRaceResults() {
        return raceResults;
    }

}
