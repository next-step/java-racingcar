package car;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static List<Integer> createCarList(int numberOfCars) {
        List<Integer> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(0);
        }
        return carList;
    }

}
