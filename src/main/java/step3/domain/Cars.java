package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> names) {
        this.carList = createCarList(names);
    }

    private List<Car> createCarList(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            list.add(new Car(names.get(i)));
        }
        return list;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
