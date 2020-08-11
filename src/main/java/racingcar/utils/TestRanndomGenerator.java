package racingcar.utils;

public class TestRanndomGenerator implements NumberGenerator {
    private final int[] values;
    private int index = 0;

    public TestRanndomGenerator(int[] values) {
        this.values = values;
    }

    @Override
    public int createRandomValue() {
        return values[index++];
    }
}
