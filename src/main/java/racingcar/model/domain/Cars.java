package racingcar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(final List<String> userInput) {
        List<Car> cars = new ArrayList<>(run(userInput));
        this.cars = cars;
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> run(final List<String> input) {
        ArrayList<Car> cars = new ArrayList<>();
        input.forEach(carNmae -> cars.add(new Car(carNmae)));
        return cars;
    }
}

