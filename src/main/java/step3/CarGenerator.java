package step3;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    private final List<Car> carList;

    CarGenerator() {
        carList = new ArrayList<>();
    }

    public void generate(int carCount) {
        for (int i = 0; i < carCount; i++)
            carList.add(new Car());
    }

    public List<Car> getCarList() {
        return carList;
    }

}
