package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getCarListSize() {
        return carList.size();
    }
}
