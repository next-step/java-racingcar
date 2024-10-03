package racingcar.study.immutable.example;

public class Age {
    private final int value;

    public Age(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Age{" +
                "value=" + value +
                '}';
    }
}
