package racewinner.domain;

import racewinner.exception.InputEmptyException;
import racewinner.exception.InvalidDelimiterException;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    private final static String SPLIT_DELIMITER = ",";
    public Cars create(final String carNameList) {
        return initCars(carNameList);
    }

    private Cars initCars(final String inputCarListName) {
        validationInput(inputCarListName);

        String[] carNameList = splitInputText(inputCarListName);

        final List<Car> cars = new ArrayList<>();
        for (String carName: carNameList) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private String[] splitInputText(final String inputCarListName) {
        return inputCarListName.split(SPLIT_DELIMITER);
    }

    private void validationInput(final String inputCarListName) {
        if (isInputNullOrEmpty(inputCarListName)) {
            throw new InputEmptyException();
        }

        if (isInputCommaNotContain(inputCarListName)) {
            throw new InvalidDelimiterException();
        }
    }
    private boolean isInputCommaNotContain(final String inputCarListName) {
        return !inputCarListName.contains(SPLIT_DELIMITER);
    }

    private boolean isInputNullOrEmpty(final String inputCarListName) {
        return inputCarListName == null || inputCarListName.isBlank();
    }
}
