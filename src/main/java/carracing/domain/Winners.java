package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> carList;

    public Winners(List<Car> carList) {
        this.carList = carList;
    }

    public int count() {
        return carList.size();
    }

    public List<String> nameList() {
        List<String> nameList = new ArrayList<>();
        for (Car car : carList) {
            nameList.add(car.racingScore().getCarName());
        }
        return nameList;
    }
}
