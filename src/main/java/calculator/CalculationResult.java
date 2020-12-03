package calculator;

public class CalculationResult {
    private int result;

    public CalculationResult(String input) {
        result = Integer.parseInt(String.valueOf(input.charAt(0)));
    }

    public int getResult() {
        return this.result;
    }

    public void set(int calculateResult) {
        this.result = calculateResult;
    }
}
