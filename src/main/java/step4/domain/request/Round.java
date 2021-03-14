package step4.domain.request;

public class Round {

    private final int MINIMUM = 0;
    private int value;

    public static Round from(String value) {
        return from(toInt(value));
    }

    public static Round from(int value) {
        return new Round(value);
    }

    private Round(int value) {
        if (isLessThanMinimum(value)) throw new IllegalArgumentException("0 이하의 숫자로는 레이싱을 진행할 수 없습니다.");
        this.value = value;
    }

    private boolean isLessThanMinimum(int value){
        return value <= MINIMUM;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

}
