package step4.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("게임을 진행할 수 없음");
        }
        initCars(names);
    }

    void initCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
