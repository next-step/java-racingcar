package step5.presentation;

public class InputValidation {

    public void validateNameOfCars(String input, String delimiter) {
        validateNone(input);
        validateNumOfCars(input, delimiter);
    }

    private void validateNone(String input) {
        if (isNone(input)) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
    }

    private boolean isNone(String input) {
        return input.isEmpty() || input.isBlank();
    }

    private void validateNumOfCars(String input, String delimiter) {
        if (hasNotDelimiter(input, delimiter)) {
            throw new IllegalArgumentException("자동차 경주엔 2대 이상의 자동차가 필요합니다.");
        }
    }

    private boolean hasNotDelimiter(String input, String delimiter) {
        return !input.contains(delimiter);
    }

    public void validateNumOfTry(String input) {
        int numOfTry = validateInteger(input);
        validateNegative(numOfTry);
    }

    private int validateInteger(String input) {
        int numOfTry;

        try {
            numOfTry = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수만 입력 가능합니다.");
        }

        return numOfTry;
    }

    private void validateNegative(int numOfTry) {
        if (isNegative(numOfTry)) {
            throw new IllegalArgumentException("시도 횟수는 양수만 입력 가능합니다.");
        }
    }

    private boolean isNegative(int numOfTry) {
        return numOfTry < 0;
    }
}
