package racingCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarRace {
    private final List<Car> cars;

    public  CarRace(int cnt) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
