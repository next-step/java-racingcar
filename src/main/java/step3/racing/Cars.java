package step3.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> unmodifiableList() {
        return Collections.unmodifiableList(carList);
    }

    public List<Car> deepCopyList() {
        return carList.stream().map(Car::new).collect(Collectors.toList());
    }

    public int count() {
        return this.carList.size();
    }
}
