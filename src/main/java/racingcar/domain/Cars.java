package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNameText) {
        Arrays.stream(carNameText.split(",")).forEach(name -> cars.add(new Car(name)));
    }

    public void race() {
        cars.forEach(Car::run);
    }
}
