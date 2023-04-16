package carRacing.domain;

import java.util.List;

import static carRacing.domain.RandomNumberGenerator.getRandomNumber;

public class Race {
    private static final int MOVE_CONDITION = 4;
    private static final boolean MOVE_SUCCESS = true;
    private static final boolean MOVE_FAIL = false;
    private static final int MOVE_DISTANCE = 1;

    public static List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();
            if (moveStatus(randomNumber)) {
                moveCar(car);
            }
            int currentLocation = car.getLocation();

        }
        return cars;
    }

    public static void moveCar(Car car) {
        int currentLocation = car.getLocation();
        car.setLocation(currentLocation + MOVE_DISTANCE);
    }

    public static boolean moveStatus(int number) {
        if (number >= MOVE_CONDITION) {
            return MOVE_SUCCESS;
        }
        return MOVE_FAIL;
    }
}
