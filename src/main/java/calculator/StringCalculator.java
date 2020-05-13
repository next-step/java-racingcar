package calculator;

public class StringCalculator {
    static void validateIsNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Null");
        }
    }

    static void validateCalc(String calc) {
        if (!"+".equals(calc) && !"-".equals(calc) && !"*".equals(calc) && !"/".equals(calc)) {
            throw new IllegalArgumentException("This is not Calculate");
        }
    }

    static double operate(double a, double b, String calc) {
        switch (calc) {
            case "+":
                return Calculator.add(a, b);
            case "-":
                return Calculator.sub(a, b);
            case "*":
                return Calculator.mul(a, b);
            case "/":
                return Calculator.div(a, b);
            default:
                return a;
        }
    }

    static double run(String input) {
        validateIsNull(input);

        String[] s = input.split(" ");
        double first = Double.parseDouble(s[0]);
        double sum = first;
        for (int i = 1; i < s.length; i += 2) {
            validateCalc(s[i]);
            int second = Integer.parseInt(s[i+1]);
            sum = operate(first,second,s[i]);
            first = sum;
        }
        return sum;
    }
}
