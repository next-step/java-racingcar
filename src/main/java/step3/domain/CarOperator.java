package step3.domain;

import step3.util.NumberGenerator;

import java.util.List;

public class CarOperator {

    private static final String CAR_MOVED = "-";

    public static List<Car> drive(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = NumberGenerator.makeRandomly();
            if (willMoving(randomNumber)) {
                car.getMovingList().add(CAR_MOVED);
            }
        }
        return carList;
    }

    public static boolean willMoving(int number) {
        return number >= 4;
    }
}
