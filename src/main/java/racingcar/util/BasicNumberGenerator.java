package racingcar.util;

public class BasicNumberGenerator implements NumberGenerator {

    private final int value;

    public BasicNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return value;
    }
}
