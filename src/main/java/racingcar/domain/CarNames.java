package racingcar.domain;

import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverLengthException;

public class CarNames {
    private static final String DELIMITER = "[,]";
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    public CarNames(String inputCarNames) {
        checkValidation(toArray(inputCarNames));
    }

    public String[] toArray(String inputCarNames) {
        return inputCarNames.split(DELIMITER);
    }

    private void checkValidation(String[] carNames) {
        for (String carName : carNames) {
            lengthCheck(carName);
        }
    }

    protected void lengthCheck(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new CarNameOverLengthException("자동차 이름 길이 초과");
        }
        if (carName.length() < MIN_LENGTH) {
            throw new CarNameEmptyException("자동차 이름 미입력");
        }
    }
}
