package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(String[] names) {
        List<Car> list = createCarList(names);
        this.carList = list;
    }

    private List<Car> createCarList(String[] names) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Car(names[i]));
        }
        return list;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
