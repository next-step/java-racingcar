package racingcar.dto;

public class InputView {
    private static final String DELIMITER = ",";
    private String[] carNames;
    private int carCount;
    private int tryCount;

    public InputView() {
    }

    public int insertCarNames(String carNameString) {
        validateNullOrEmpty(carNameString);
        this.carNames = splitCarNames(carNameString);
        this.carCount = carNames.length;
        return carCount;
    }

    public int insertTryCount(String stringTryCount) {
        validateNullOrEmpty(stringTryCount);
        this.tryCount = validateNumberType(stringTryCount);
        return tryCount;
    }

    private String[] splitCarNames(String stringInput) {
        return stringInput.split(DELIMITER);
    }

    private int validateNumberType(String stringInput) {
        int intInput = validateNumber(stringInput);
        validateNegative(intInput);
        return intInput;
    }

    private void validateNullOrEmpty(String stringInput) {
        validateNull(stringInput);
        validateEmpty(stringInput);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("공백 문자열은 입력할 수 없습니다.");
        }
    }

    private int validateNumber(String input) {
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return validateNegative(intInput);
    }

    private int validateNegative(int intInput) {
        if (intInput <= 0) {
            throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
        }
        return intInput;
    }

    public int getTryCount() {
        return tryCount;
    }
}