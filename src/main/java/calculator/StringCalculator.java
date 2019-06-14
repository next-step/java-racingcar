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

    public void isNotEmpty(String s) {
        if (s == null || "".equals(s.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public String isOperation(String s) {
        if (!"+-*/".contains(s)) {
            throw new IllegalArgumentException();
        }
        return s;
    }

    public int calculate(String[] strings) {
        int result = Integer.parseInt(strings[0]);
        String operator = null;
        for (int i = 1; i < strings.length; i++) {
            if (i % 2 != 0) {
                operator = isOperation(strings[i]);
            }
            if (i % 2 == 0) {
                switch (operator) {
                    case "+" :
                        result = add(result, Integer.parseInt(strings[i]));
                        break;
                    case "-" :
                        result = subtract(result, Integer.parseInt(strings[i]));
                        break;
                    case "*" :
                        result = multiply(result, Integer.parseInt(strings[i]));
                        break;
                    case "/" :
                        result = divide(result, Integer.parseInt(strings[i]));
                        break;
                }
            }
        }
        return result;
    }
}
