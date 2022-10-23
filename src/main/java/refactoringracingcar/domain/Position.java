package refactoringracingcar.domain;

import java.util.List;

public class Position {

    private static final int CAR_DEFAULT_POSITION = 0;

    public Car resetCarStatus(String carName) {
        return new Car(carName, CAR_DEFAULT_POSITION);
    }

    public int moveCarUnit(boolean discriminationMove) {
        if (discriminationMove) {
            return 1;
        }
        return 0;
    }

    public List<Car> updateCarStatus(int carNumber, int moveDistance, List<Car> cars) {
        cars.get(carNumber).setCarPosition(cars.get(carNumber).getCarPosition() + moveDistance);
        return cars;
    }
}
