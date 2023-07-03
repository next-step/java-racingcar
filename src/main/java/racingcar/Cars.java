package racingcar;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static String[] split(String str) {
        return str.split(",");
    }
}
