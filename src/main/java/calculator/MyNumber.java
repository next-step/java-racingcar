package calculator;

public class MyNumber {
    private final int number;

    public MyNumber(int num) {
        number = num;
    }

    public MyNumber(String s) {
        this(Integer.parseInt(validNull(s)));
    }

    public int getNumber() {
        return number;
    }

    public boolean has(int i) {
        return number == i;
    }

    public MyNumber plus(MyNumber other) {
        return new MyNumber(number + other.number); // 왜 getNumber(); 는 안되는가?
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(number - other.number); // 왜 getNumber(); 는 안되는가?
    }

    public MyNumber multiple(MyNumber other) {
        return new MyNumber(number * other.number); // 왜 getNumber(); 는 안되는가?
    }

    public MyNumber divide(MyNumber other) {
        valid(other);
        return new MyNumber(number / other.number); // 왜 getNumber(); 는 안되는가?
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

    private void valid(MyNumber other) {
        if (other.getNumber() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
