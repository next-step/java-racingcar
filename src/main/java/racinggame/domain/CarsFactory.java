package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static Cars cars(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
