package racewinner;

import racewinner.expteion.CarNameTooLongException;
import racewinner.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final static String TOO_LONG_CAR_NAME_MSG = "자동차의 이름은 5글자를 초과 할 수 없습니다.";
    private final static String STEP_STRING = "-";

    private final List<Car> carList = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public CarList(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void add(final String name) {
        carNameCheck(name);

        carList.add(new Car(name, moveStrategy));
    }

    private void carNameCheck(final String name) {
        if (name.length() > 5) {
            throw new CarNameTooLongException(TOO_LONG_CAR_NAME_MSG);
        }
    }

    public void move() {
        for (Car car: carList) {
            car.move();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car: carList) {
            stringBuilder.append(String.format("%s : %s", car.name(), STEP_STRING.repeat(car.currentStep())) + "\n");
        }
        return stringBuilder.toString();
    }
}
