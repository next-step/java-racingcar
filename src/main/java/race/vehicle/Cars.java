package race.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int num) {
        if(num < 2){
            throw new IllegalArgumentException("게임을 진행할 수 없음");
        }
        initCars(num);
    }

    Cars initCars(int num) {
        for (int i = 0; i < num; i++) {
            cars.add(new Car());
        }
        return this;
    }

    public List<Car> getCars() {
        return cars;
    }
}