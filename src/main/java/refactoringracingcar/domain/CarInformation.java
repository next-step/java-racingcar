package refactoringracingcar.domain;

import refactoringracingcar.racingexception.ExceptionCommand;
import refactoringracingcar.racingexception.InputValueException;

import java.util.List;

public class CarInformation {

    private static final int CAR_DEFAULT_POSITION = 0;
    private static ExceptionCommand exceptionCommand = new ExceptionCommand();

    public String[] splitCarNames(String carNames) {
        String[] carsName = carNames.split(",");
        for (String carName : carsName) {
            validateNullValue(carName);
        }
        return carsName;
    }

    private void validateNullValue(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new InputValueException(exceptionCommand.NULL_EXCEPTION_MESSAGE);
        }
        if (carName.length() > 5) {
            throw new InputValueException(exceptionCommand.NAME_MAX_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public Car resetCarStatus(String carName) {
        return new Car(carName, CAR_DEFAULT_POSITION);
    }

    public List<Car> updateCarStatus(List<Integer> distances, List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setCarPosition(cars.get(i).getCarPosition() + distances.get(i));
        }
        return cars;
    }
}
