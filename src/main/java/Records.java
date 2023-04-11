import java.util.*;

public class Records {

    private final List<CarRecord> gameRecord = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    public void add(Cars cars) {
        for (Car car : cars.cars()) {
            gameRecord.add(new CarRecord(car.name(), car.distance()));
        }
    }

    public void addWinners(Cars cars) {
        int maxDistance = maxDistance(cars);

        for (Car car : cars.cars()) {
            findWinner(car, maxDistance);
        }
    }

    private int maxDistance(Cars cars) {
        int maxDistance = 0;

        for (Car car : cars.cars()) {
            maxDistance = Math.max(maxDistance, car.distance());
        }

        return maxDistance;
    }

    private void findWinner(Car car, int maxDistance) {
        if (car.distance() == maxDistance) {
            winners.add(car);
        }
    }

    public List<CarRecord> gameRecord() {
        return gameRecord;
    }

    public List<Car> winners() {
        return winners;
    }

}
