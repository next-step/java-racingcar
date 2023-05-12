package step3.domain;

import step3.util.NumberGenerator;

import java.util.List;

public class CarOperator {

    public static List<Car> drivingResult(List<Car> carList) {
        for(Car car : carList) {
            int randomNumber = NumberGenerator.makeRandomly();
            car.drive(randomNumber);
        }
        return carList;
    }

}
