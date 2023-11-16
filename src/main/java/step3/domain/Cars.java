package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public int size() {
        return this.carList.size();
    }

    public List<Car> carList() {
        return Collections.unmodifiableList(this.carList);
    }
}
