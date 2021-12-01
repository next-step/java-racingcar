package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NamesAsCars {
    private final String carNames;

    public NamesAsCars(String carNames) {
        this.carNames = carNames;
    }

    public Cars cars() {
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
