package racinggame.domain.car;

import java.util.List;
import racinggame.domain.exception.InvalidCarIndexException;
import racinggame.domain.exception.InvalidCarRegistrationException;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> cars) {
        validateCarCount(cars);
        this.carList = cars;
    }

    private void validateCarCount(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new InvalidCarRegistrationException();
        }
    }

    public Car getCar(int index) {
        try {
            return carList.get(index);
        } catch (Exception e) {
            throw new InvalidCarIndexException();
        }
    }

    public int getSize() {
        return carList.size();
    }

}
