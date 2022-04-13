package racingCar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CarStadium {

    private static final int BOUND = 10;

    private static final Random random = new Random();

    private static LinkedList<Car> carList = new LinkedList<>();
    private static int rounds = 0;

    public static int extractRandomNumber() {
        return random.nextInt(BOUND);
    }

    public static void initCars(String cars) {

        String[] carNames = splitCarNames(cars);

        for (int i = 0; i < carNames.length; ++i) {
            Car car = new Car(carNames[i], new NormalStrategy());
            carList.add(car);
        }
    }

    private static String[] splitCarNames(String cars) {
        return cars.split(",");
    }

    public static void initRounds(int nums) {
        rounds = nums;
    }

    public static int getRounds() {
        return rounds;
    }

    public static LinkedList<Car> getCars() {
        return carList;
    }

    public static ArrayList<String> getWinners(LinkedList<Car> list) {
        ArrayList<String> winners = findWinners(list, getMaxDistance(list));

        return winners;
    }

    private static ArrayList<String> findWinners(LinkedList<Car> list, int max) {
        ArrayList<String> winners = new ArrayList<>();

        for (int j = 0; j < list.size(); ++j) {
            Car car = list.get(j);
            addWinners(max, winners, car);
        }

        return winners;
    }

    private static void addWinners(int max, ArrayList<String> winners, Car car) {
        if (max == car.getDistance().length()) {
            winners.add(car.getName());
        }
    }

    private static int getMaxDistance(LinkedList<Car> list) {
        int maxDistance = 0;

        for (int j = 0; j < list.size(); ++j) {
            int distance = list.get(j).getDistance().length();
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
