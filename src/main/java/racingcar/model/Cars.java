package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    private Cars() {}

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars(){

        if(this.cars == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.cars);
    }
}

