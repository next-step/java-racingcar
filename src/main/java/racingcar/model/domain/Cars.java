package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.vo.Car;

public class Cars {

    private List<Car> cars;

    public Cars(final List<String> userInput) {
        run(userInput);
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void run(final List<String> input) {
        cars = new ArrayList<>();
        input.stream().forEach(carNmae->cars.add(new Car(carNmae)));
    }
}

