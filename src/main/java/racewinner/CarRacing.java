package racewinner;

import racewinner.expteion.InvalidDelimiterException;
import racewinner.expteion.InputEmptyException;

public class CarRacing {
    private final static String INPUT_EMPTY_MSG = "빈 값을 입력 할 수 없습니다.";
    private final static String INVALID_DELIMITER_MSG = "','구분자 외의 다른 구분자를 사용 할 수 없습니다.";
    private final static String SPLIT_DELIMITER = ",";
    private final CarList carList = new CarList();
    public CarRacing(String inputCarListName) {
        validationInput(inputCarListName);

        String[] carNameList = splitInputText(inputCarListName);

        for (String carName: carNameList) {
            carList.add(carName);
        }
    }

    private static String[] splitInputText(final String inputCarListName) {
        String[] carNameList = inputCarListName.split(SPLIT_DELIMITER);
        return carNameList;
    }

    private void validationInput(final String inputCarListName) {
        if (isInputNullOrEmpty(inputCarListName)) {
            throw new InputEmptyException(INPUT_EMPTY_MSG);
        }

        if (isInputCommaNotContain(inputCarListName)) {
            throw new InvalidDelimiterException(INVALID_DELIMITER_MSG);
        }
    }

    private boolean isInputCommaNotContain(final String inputCarListName) {
        return !inputCarListName.contains(SPLIT_DELIMITER);
    }

    private boolean isInputNullOrEmpty(final String inputCarListName) {
        return inputCarListName == null || inputCarListName.isBlank();
    }

}
