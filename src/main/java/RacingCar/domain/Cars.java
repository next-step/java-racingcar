package RacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> makeCars(String input) {
        List<Car> cars = new ArrayList<>();

        String[] carArray = input.split(",");

        init(carArray, cars);

        return cars;
    }

    private void init(String[] carArray, List<Car> carList) {
        for (String carName : carArray) {
            carList.add(new Car(carName, 1));
        }
    }
}
