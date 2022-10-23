package refactoringracingcar.domain;

import refactoringracingcar.racingexception.ExceptionCommand;
import refactoringracingcar.racingexception.InputValueException;

import static refactoringracingcar.racingexception.ExceptionCommand.NULL_EXCEPTION_MESSAGE;

public class CarName {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String carName;

    public CarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new InputValueException(NULL_EXCEPTION_MESSAGE);
        }
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new InputValueException(ExceptionCommand.NAME_MAX_LENGTH_EXCEPTION_MESSAGE);
        }

        this.carName = carName;
    }

}
