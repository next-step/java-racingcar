package step3;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    public List<CarList> gameStart(int numberOfCars, int tryCounts) {
        CarController carController = new CarController();

        CarList carList = carController.initCarList(numberOfCars);

        List<CarList> carListResult = new ArrayList<>();

        for(int tryNumber = 0; tryNumber < tryCounts; tryNumber++) {
            carListResult.add(carController.nextPosition(carList));
        }

        return carListResult;
    }
}
