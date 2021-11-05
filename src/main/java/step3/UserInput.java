package step3;

public class UserInput {

    private final static String NUMBER_PATTERN = "\\d*$";
    private final static String NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private final static String NULL_EXCEPTION_MESSAGE = "입력 값이 없습니다.";

    private final String countStr;
    private final String timeStr;

    private UserInput(String countStr, String timeStr) {
        this.countStr = countStr;
        this.timeStr = timeStr;
    }

    public static UserInput create(String countStr, String timeStr) {
        return new UserInput(countStr, timeStr);
    }

    public void validate() {
        isNullOrEmptyForString(countStr);
        isNumberForString(countStr);

        isNullOrEmptyForString(timeStr);
        isNumberForString(timeStr);
    }

    public String getCountStr() {
        return countStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    private void isNumberForString(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void isNullOrEmptyForString(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }

    private void isNull(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }
}
