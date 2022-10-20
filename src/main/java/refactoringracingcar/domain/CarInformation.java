package refactoringracingcar.domain;

import refactoringracingcar.racingexception.InputValueException;

import java.util.List;

import static refactoringracingcar.racingexception.ExceptionCommand.NAME_MAX_LENGTH_EXCEPTION_MESSAGE;
import static refactoringracingcar.racingexception.ExceptionCommand.NULL_EXCEPTION_MESSAGE;

public class CarInformation {

    private static final int CAR_DEFAULT_POSITION = 0;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public String[] splitCarNames(String carNames) {
        String[] carsName = carNames.split(",");
        for (String carName : carsName) {
            validateNullValue(carName);
        }
        return carsName;
    }

    private void validateNullValue(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new InputValueException(NULL_EXCEPTION_MESSAGE);
        }
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new InputValueException(NAME_MAX_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public Car resetCarStatus(String carName) {
        return new Car(carName, CAR_DEFAULT_POSITION);
    }

    public List<Car> updateCarStatus(int carNumber, int moveDistance, List<Car> cars) {
        cars.get(carNumber).setCarPosition(cars.get(carNumber).getCarPosition() + moveDistance);
        return cars;
    }
}
