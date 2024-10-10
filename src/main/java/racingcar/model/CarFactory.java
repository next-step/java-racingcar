package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static final String DELIMITER = ",";

    public static List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();

        for (String name: names.split(DELIMITER)) {
    // 이름 유효성 검사 추가
                cars.add(new Car(name));
        }

        return cars;
    }
}
