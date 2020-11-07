package racing;

import java.util.List;
import java.util.Random;

public class Car {

    private final StringBuilder stringBuilder;

    public Car() {
        stringBuilder = new StringBuilder();
    }

    public static void forward(List<Car> cars) {
        for (Car car : cars) {
            validateForward(car);
        }
    }

    private static void validateForward(Car car) {
        int randomNumber = new Random().nextInt(10);
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    private void forward() {
        stringBuilder.append("-");
    }

    public String getStr() {
        return stringBuilder.toString();
    }
}
