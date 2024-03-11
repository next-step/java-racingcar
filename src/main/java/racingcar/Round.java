package racingcar;

public class Round {

    private final int value;

    public Round(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("라운드 수는 자연수만 가능합니다");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
