package calculator;

public class StringCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isNotEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public String isOperation(String s) {
        if (!"+-*/".contains(s)) {
            throw new IllegalArgumentException();
        }
        return s;
    }

    public int calculate(String input) {
        if (isNotEmpty(input)) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        int result = convertInteger(strings[0]);

        String operator = null;

        for (int i = 1; i < strings.length; i++) {
            if (i % 2 != 0) {
                operator = isOperation(strings[i]);
            }
            if (i % 2 == 0) {
                switch (operator) {
                    case "+" :
                        result = add(result, convertInteger(strings[i]));
                        break;
                    case "-" :
                        result = subtract(result, convertInteger(strings[i]));
                        break;
                    case "*" :
                        result = multiply(result, convertInteger(strings[i]));
                        break;
                    case "/" :
                        result = divide(result, convertInteger(strings[i]));
                        break;
                }
            }
        }
        return result;
    }

    public int convertInteger(String s) {
        return Integer.parseInt(s);
    }
}
