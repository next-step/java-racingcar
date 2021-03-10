package racingcar.domain.request;

public class Amount {

    private final int MINIMUM = 0;
    private int value;

    public static Amount getInstance(String value) {
        return getInstance(toInt(value));
    }

    public static Amount getInstance(int value) {
        return new Amount(value);
    }

    private Amount(int amount) {
        if (amount <= MINIMUM) throw new IllegalArgumentException("0 이하의 숫자로는 자동차를 생성할 수 없습니다.");
        this.value = amount;
    }

    private static int toInt(String amount) {
        return Integer.parseInt(amount);
    }

    public int getValue() {
        return value;
    }


}
