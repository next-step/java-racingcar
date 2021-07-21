package step2;

public class FIFOCalculator {
    private String rawInput;

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public void validateInput() {
        if (rawInput == null || rawInput.trim().equals("")) {
            throw new IllegalArgumentException();
        }

        if (!rawInput.replaceAll(" ", "").matches("^[0-9+\\-*/]+$")) {
            throw new IllegalArgumentException();
        }
    }
}
