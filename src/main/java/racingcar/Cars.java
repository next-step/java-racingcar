package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(int size) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.carList.add(new Car());
        }
    }

    public int size() {
        return carList.size();
    }
}
