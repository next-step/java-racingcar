package car;

import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;

    public void carDrive(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = (int) (Math.random() * MAXIMUM_RANDOM_NUMBER);

            car.changeKm(randomNumber);
        }
    }
}
