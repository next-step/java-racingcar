package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    int times;
    List<Car> cars;

    public CarRacing(int times, String inputNames) throws Exception {
        this.times = times;
        this.cars = new ArrayList<>();

        String[] carNames = inputNames.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
