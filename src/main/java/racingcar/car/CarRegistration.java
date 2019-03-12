package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarRegistration {

    private List<Car> cars;

    public List<Car> register(String[] racers) {
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < racers.length; i++) {
            this.cars.add(new Car(racers[i], 0));
        }

        return this.cars;
    }
}
