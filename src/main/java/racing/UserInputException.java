package racing;

public class UserInputException extends Exception {

    private static final String NOT_NUMBER_FORMAT_MESSAGE = "숫자 이외의 값이 포함되어 있습니다.";
    private static final String NOT_POSITIVVE_MESSAGE = "음수가 포함되어 있습니다.";

    public static int isValidForNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new RuntimeException(NOT_POSITIVVE_MESSAGE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER_FORMAT_MESSAGE);
        }
    }
}
