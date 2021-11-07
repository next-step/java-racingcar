package step4;

public class UserInput {

    private final static String NUMBER_PATTERN = "\\d*$";
    private final static String NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private final static String NULL_EXCEPTION_MESSAGE = "입력 값이 없습니다.";
    private final static String NAMES_NOT_HAVE_COMMA_MESSAGE = "이름 값은 ,로 구분됩니다.";

    private final String names;
    private final String timeStr;

    private UserInput(String names, String timeStr) {
        this.names = names;
        this.timeStr = timeStr;
    }

    public static UserInput create(String names, String timeStr) {
        return new UserInput(names, timeStr);
    }

    public void validate() {
        isNullOrEmptyForString(names);
        isComma(names);

        isNullOrEmptyForString(timeStr);
        isNumberForString(timeStr);
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

    private void isComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NAMES_NOT_HAVE_COMMA_MESSAGE);
        }
    }
}
