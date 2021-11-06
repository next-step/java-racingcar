package calculator.ver3;

public class MyNumberVer3 {
    private final int number;

    public MyNumberVer3(int num) {
        number = num;
    }

    public MyNumberVer3(String s) {
        this(Integer.parseInt(validNull(s)));
    }

    public int getNumber() {
        return number;
    }

    private static String validNull(String text) {
        if (text == null) {
            throw new IllegalArgumentException("값이 null 일 수 없습니다.");
        }

        if (text.isEmpty()) {
            throw new IllegalArgumentException("값이 공백일 수 없습니다.");
        }

        return text;
    }

}
