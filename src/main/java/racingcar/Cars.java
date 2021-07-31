package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String ...names) {
        for(String name : names) {
            cars.add(new Car(name));
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
