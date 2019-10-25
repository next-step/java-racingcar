public class StringCalculator {
    private String[] input;

    public StringCalculator(String input) {
        inputValidator(input);
        this.input = input.split(" ");
        resultPrint();
    }

    private void inputValidator(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void resultPrint() {
        System.out.println(calculator(this.input.length - 1));
    }

    private int calculator(int number) {
        if (number == 0) {
            return Integer.parseInt(input[number]);
        }
        return branchMethod(number);
    }


    private int branchMethod(int number) {
        switch (input[number]) {
            case "+" : return add(number);
            case "-" : return subtract(number);
            case "*" : return multiply(number);
            case "/" : return divide(number);
            default: return isNumber(number);
        }
    }

    private int add(int number) {
        return calculator(number -1) + Integer.parseInt(input[number + 1]);
    }

    private int subtract(int number) {
        return calculator(number -1) - Integer.parseInt(input[number + 1]);
    }

    private int divide(int number) {
        return calculator(number -1) / Integer.parseInt(input[number + 1]);
    }

    private int multiply(int number) {
        return calculator(number -1) * Integer.parseInt(input[number + 1]);
    }

    private int isNumber(int number) {
        try {
            Integer.parseInt(input[number]);
            return calculator(number - 1);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
