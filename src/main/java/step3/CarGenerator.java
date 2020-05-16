package step3;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {
    private final List<Car> carList;

    GameInitializer() {
        carList = new ArrayList<>();
    }

    public void generateCar(int carCount) {
        for (int i = 0; i < carCount; i++)
            carList.add(new Car());
    }

    public List<Car> getCarList() {
        return carList;
    }

}
