package racingcar.model.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.entity.Car;

public class Cars {

    private List<Car> cars;

    public Cars(final List<String> userInput) {
        run(userInput);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run(final List<String> input) {
        cars = new ArrayList<>();
        for (String carName : input) {
            cars.add(new Car(carName));
        }
    }
}

