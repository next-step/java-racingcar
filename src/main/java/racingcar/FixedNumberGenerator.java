package racingcar;

public class FixedNumberGenerator implements NumberGenerator {
    int[] numbers;

    public FixedNumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] generateNumbers(int count) {
        return numbers;
    }
}
