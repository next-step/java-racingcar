package racinggame.domain.car;

import java.util.List;
import racinggame.domain.exception.InvalidCarIndexException;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
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
