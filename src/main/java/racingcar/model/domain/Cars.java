package racingcar.model.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.entity.Car;

public class Cars {

    private List<Car> cars;
    private Racing racing;

    public Cars(final List<String> userInput) {
        run(userInput);
    }

    public Racing getRacing() {
        return racing;
    }

    public void run(final List<String> input) {
        cars = new ArrayList<>();
        for (String carName : input) {
            cars.add(Car.get(carName));
        }
        racing = Racing.get(cars);
    }

}

