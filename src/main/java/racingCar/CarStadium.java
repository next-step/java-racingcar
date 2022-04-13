package racingCar;

import java.util.LinkedList;
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


}
