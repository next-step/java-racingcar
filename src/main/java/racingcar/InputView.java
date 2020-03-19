package racingcar;

import static racingcar.InputType.*;

public class InputView {
    private int carCount;
    private int tryCount;

    public InputView(String input, InputType inputType) {
        validateNull(input);
        validateEmpty(input);
        int number = validateNumber(input);
        insertNumberIntoField(number, inputType);
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

    private void insertNumberIntoField(int intInput, InputType inputType){
        if(CAR.equals(inputType)){
            this.carCount = intInput;
        }
        if(TRY.equals(inputType)){
            this.tryCount = intInput;
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
