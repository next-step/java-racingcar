package racingcar;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static String[] split(String str) {
        return str.split(",");
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress();
        }
    }
}
