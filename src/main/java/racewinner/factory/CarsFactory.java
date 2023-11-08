package racewinner.factory;

import racewinner.domain.Car;
import racewinner.domain.Cars;
import racewinner.domain.strategy.MoveStrategy;
import racewinner.domain.strategy.RandomMoveStrategy;
import racewinner.expteion.InputEmptyException;
import racewinner.expteion.InvalidDelimiterException;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    private final static String SPLIT_DELIMITER = ",";
    public Cars create(final String carNameList) {
        return initCars(carNameList, new RandomMoveStrategy());
    }

    private Cars initCars(final String inputCarListName, final MoveStrategy moveStrategy) {
        validationInput(inputCarListName);

        String[] carNameList = splitInputText(inputCarListName);

        final List<Car> cars = new ArrayList<>();
        for (String carName: carNameList) {
            cars.add(new Car(carName, moveStrategy));
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
