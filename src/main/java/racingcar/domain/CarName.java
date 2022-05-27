package racingcar.domain;

public class CarName {
    private static final String DELIMITER = "[,]";
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private String[] carNames;

    public CarName(String inputCarNames) {
        inputCarNames = inputCarNames.replace(" ", "");
        carNames = toArray(inputCarNames);
        checkValidation(carNames);
    }

    private String[] toArray(String inputCarNames) {
        carNames = inputCarNames.split(DELIMITER);
        return carNames;
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

    public String[] getCarNames() {
        return carNames;
    }
}
