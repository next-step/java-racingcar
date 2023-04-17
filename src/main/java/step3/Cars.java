package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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

    public void actionAll(Consumer<Car> action) {
        this.carList.parallelStream().forEach(action);
    }

    public int count() {
        return this.carList.size();
    }

    public List<Car> deepCopyList() {
        return carList.stream().map(Car::clone).collect(Collectors.toList());
    }
}
