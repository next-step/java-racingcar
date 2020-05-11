package stringCalculator;

public class Calculator {

    public int main(String input) {
        emptyInputCheck(input);

        String[] splitString = splitString(input);
        int total = Integer.parseInt(splitString[0]);

        for (int i = 1; i < splitString.length; i += 2) {
            String operator = splitString[i];
            int target = Integer.parseInt(splitString[i + 1]);

            total = calculate(total, target, operator);
        }

        return total;
    }

    private void emptyInputCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
    }

    private String[] splitString(String input) {
        return input.split(" ");
    }

    private int calculate(int total, int target, String operator) {
        if (operator.equals("+")) {
            return total + target;
        }

        if (operator.equals("-")) {
            return total - target;
        }

        if (operator.equals("*")) {
            return total * target;
        }

        if (operator.equals("/")) {
            return total / target;
        }

        throw new IllegalArgumentException("Not supported operator");
    }
}
