package calculator;

public class Calculator {
    private int[] numbers;

    public Calculator(int[] numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
