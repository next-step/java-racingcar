package racingCar.domain;

import racingCar.NormalStrategy;
import racingCar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarStadium {

    private static final int BOUND = 10;

    private static final Random random = new Random();

    private static List<Car> carList = new ArrayList<>();
    private static int rounds = 0;

    public static int extractRandomNumber() {
        return random.nextInt(BOUND);
    }

    public static void initCars(String[] carNames) {
        for (String name : carNames) {
            Car car = new Car(name, new NormalStrategy());
            carList.add(car);
        }
    }

    public static void initRounds(int nums) {
        rounds = nums;
    }

    public static int getRounds() {
        return rounds;
    }

    public static List<Car> getCars() {
        return carList;
    }

    public static void moveCar(Car car) {
        car.move(extractRandomNumber());
    }

    public static List<String> getWinners(List<Car> cars) {
        List<String> winners = findWinners(cars, getMaxDistance(cars));

        return winners;
    }

    private static List<String> findWinners(List<Car> cars, int max) {
        List<String> winners = new ArrayList<>();

        for (int j = 0; j < cars.size(); ++j) {
            Car car = cars.get(j);
            addWinners(max, winners, car);
        }

        return winners;
    }

    private static void addWinners(int max, List<String> winners, Car car) {
        if (max == car.getPosition()) {
            winners.add(car.getName());
        }
    }

    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (int j = 0; j < cars.size(); ++j) {
            int distance = cars.get(j).getPosition();
            maxDistance = getMaxDistance(maxDistance, distance);
        }

        return maxDistance;
    }

    private static int getMaxDistance(int maxDistance, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
        }
        return maxDistance;
    }
}
