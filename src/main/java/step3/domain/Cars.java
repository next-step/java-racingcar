package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(CarNameList list) {
        return new Cars(list.getCarNameList()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
