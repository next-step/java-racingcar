package racingcar.domain.request;

public class Amount {

    private final int MINIMUM = 0;
    private int value;

    public static Amount from(String value) {
        return from(toInt(value));
    }

    public static Amount from(int value) {
        return new Amount(value);
    }

    private Amount(int value) {
        if (value <= MINIMUM) throw new IllegalArgumentException("0 이하의 숫자로는 자동차를 생성할 수 없습니다.");
        this.value = value;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }


}
