package step2;

public class StringCalculator {

    private static InputCheck inputCheck;

    public StringCalculator(InputCheck inputCheck) {
        this.inputCheck = inputCheck;
    }

    public int calculate() {
        int result = Integer.parseInt(inputCheck.inputArray[0]);
        // calculate
        for (int i = 0; i < inputCheck.inputArray.length - 1; i += 2) {
            result = calculateProcess(result, Integer.parseInt(inputCheck.inputArray[i + 2]), inputCheck.inputArray[i + 1]);
        }
        return result;
    }

    private int calculateProcess(int result, int nextNumber, String calculateSymbol) {
        if ("+".equals(calculateSymbol)) {
            result += nextNumber;
        }
        if ("-".equals(calculateSymbol)) {
            result -= nextNumber;
        }
        if ("*".equals(calculateSymbol)) {
            result *= nextNumber;
        }
        if ("/".equals(calculateSymbol)) {
            result /= nextNumber;
        }
        return result;
    }

}
