package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames, String scoreSymbol) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

}
