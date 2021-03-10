package racingcar.domain.request;

public class Round {

    private final int MINIMUM = 0;
    private int value;

    public static Round getInstance(String value) {
        return getInstance(toInt(value));
    }

    public static Round getInstance(int value) {
        return new Round(value);
    }

    private Round(int value) {
        if (value <= MINIMUM) throw new IllegalArgumentException("0이하의 숫자로는 레이싱을 진행할 수 없습니다.");
        this.value = value;
    }

    private static int toInt(String round) {
        return Integer.parseInt(round);
    }

    public int getValue() {
        return value;
    }

}
