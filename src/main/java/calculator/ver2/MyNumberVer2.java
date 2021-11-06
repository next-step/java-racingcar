package calculator.ver2;

public class MyNumberVer2 {
    private final int number;

    public MyNumberVer2(int num) {
        number = num;
    }

    public MyNumberVer2(String s) {
        this(Integer.parseInt(validNull(s)));
    }

    public int getNumber() {
        return number;
    }

    public boolean has(int i) {
        return number == i;
    }

    public MyNumberVer2 plus(MyNumberVer2 other) {
        return new MyNumberVer2(number + other.number); // other.getNumber() 도 가능하다
    }

    public MyNumberVer2 minus(MyNumberVer2 other) {
        return new MyNumberVer2(number - other.number); // other.getNumber() 도 가능하다
    }

    public MyNumberVer2 multiple(MyNumberVer2 other) {
        return new MyNumberVer2(number * other.number); // other.getNumber() 도 가능하다
    }

    public MyNumberVer2 divide(MyNumberVer2 other) {
        valid(other);
        return new MyNumberVer2(number / other.number); // other.getNumber() 도 가능하다
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

    private void valid(MyNumberVer2 other) {
        if (other.getNumber() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
