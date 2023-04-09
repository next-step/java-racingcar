import java.util.*;

public class Cars {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;
    private final int START_POSITION = 0;

    private final Map<Car, List<Integer>> distancesOfCar = new HashMap<>();

    public Cars(List<Car> cars) {
        for (Car car : cars) {
            distancesOfCar.put(car, new ArrayList<>(START_POSITION));
        }
    }

    public Map<Car, List<Integer>> distancesOfCar() {
        return distancesOfCar;
    }

    public void race(int trial) {
        for (int i = 0; i < trial; i++) {
            move();
            saveDistance();
        }
    }

    public void move() {
        for (Car car : distancesOfCar.keySet()) {
            car.go(canMove());
        }
    }

    public void saveDistance() {
        distancesOfCar.forEach(
                (key, value) -> distancesOfCar.get(key).add(key.distance()));
    }

    private static boolean canMove() {
        return random.nextInt(10) >= FORWARD_CONDITION;
    }

    public List<Car> winners() {

        List<Car> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();

        for (Car car : distancesOfCar.keySet()) {
            findWinner(winners, maxDistance, car);
        }

        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = START_POSITION;

        for (Car car : distancesOfCar.keySet()) {
            maxDistance = Math.max(maxDistance, car.distance());
        }

        return maxDistance;
    }

    private void findWinner(List<Car> winners, int maxDistance, Car car) {
        if (car.distance() == maxDistance) {
            winners.add(car);
        }
    }
}
