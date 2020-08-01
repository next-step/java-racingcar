package step2.collections;

public class InputNumbers {

    private final Integer[] numbers;

    public InputNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }

    public Integer size() {
        return this.numbers.length;
    }

    public Integer get(Integer index) {
        return this.numbers[index];
    }
}
