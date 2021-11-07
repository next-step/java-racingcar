package calculator.ver3;

public class MyNumberVer3 {
    private final int number;
    private final static String ERR_MSG_NULL = "값이 null 일 수 없습니다.";
    private final static String ERR_MSG_EMPTY = "값이 공백일 수 없습니다.";

    public MyNumberVer3(int num) {
        number = num;
    }

    public MyNumberVer3(String numByText) {
        this(Integer.parseInt(validNull(numByText)));
    }

    public int getNumber() {
        return number;
    }

    private static String validNull(String text) {
        if (text == null) {
            throw new IllegalArgumentException(ERR_MSG_NULL);
        }

        if (text.isEmpty()) {
            throw new IllegalArgumentException(ERR_MSG_EMPTY);
        }

        return text;
    }

}
