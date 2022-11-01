package racingcar.generator;

public class ManualValueGenerator implements Generator {

    private final int value;

    public ManualValueGenerator(int value) {
        this.value = value;
    }

    public int nextValue() {
        return value;
    }
}
