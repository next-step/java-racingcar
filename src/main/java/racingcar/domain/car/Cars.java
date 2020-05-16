package racingcar.domain.car;

import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars){
        if(Objects.isNull(cars)) {
            throw new NullPointerException();
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public void clearAll(){
        cars.forEach(Car::clearPosition);
    }
}
