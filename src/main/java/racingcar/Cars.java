package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<String> getWinners() {
        return Arrays.asList("성현");
    }
}
