package carracing.domain;

import java.util.List;

import static carracing.domain.RandomNumberGenerator.getRandomNumber;

public class Race {
    private static final int MOVE_CONDITION = 4;
    private static final boolean MOVE_SUCCESS = true;
    private static final boolean MOVE_FAIL = false;

    public static List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();
            if (moveStatus(randomNumber)) {
                moveCar(car);
            }

        }
        return cars;
    }

    public static void moveCar(Car car) {
        car.move();
    }

    public static boolean moveStatus(int number) {
        if (number >= MOVE_CONDITION) {
            return MOVE_SUCCESS;
        }
        return MOVE_FAIL;
    }
}
