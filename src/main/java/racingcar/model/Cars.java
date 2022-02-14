package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> racingCars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
