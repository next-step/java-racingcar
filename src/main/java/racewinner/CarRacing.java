package racewinner;

import racewinner.expteion.InvalidDelimiterException;
import racewinner.expteion.InputEmptyException;

public class CarRacing {
    private final CarList carList = new CarList();
    public CarRacing(String inputCarListName) {
        validationInput(inputCarListName);

        String[] carNameList = splitInputText(inputCarListName);

        for (String carName: carNameList) {
            carList.add(carName);
        }
    }

    private static String[] splitInputText(final String inputCarListName) {
        String[] carNameList = inputCarListName.split(",");
        return carNameList;
    }

    private void validationInput(final String inputCarListName) {
        if (isInputNullOrEmpty(inputCarListName)) {
            throw new InputEmptyException("빈 값을 입력 할 수 없습니다.");
        }

        if (isInputCommaNotContain(inputCarListName)) {
            throw new InvalidDelimiterException("','구분자 외의 다른 구분자를 사용 할 수 없습니다.");
        }
    }

    private boolean isInputCommaNotContain(final String inputCarListName) {
        return !inputCarListName.contains(",");
    }

    private boolean isInputNullOrEmpty(final String inputCarListName) {
        return inputCarListName == null || inputCarListName.isBlank();
    }

}
