package calculator;

public class StringCalculator {
    static void validateIsNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Null");
        }
    }

    static void validateOperator(String calc) {
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

        String[] splitFormula = input.split(" ");
        validateLength(splitFormula.length);

        double first = Double.parseDouble(splitFormula[0]);
        double sum = first;
        for (int i = 1; i < splitFormula.length; i += 2) {
            validateOperator(splitFormula[i]);

            double second = Double.parseDouble(splitFormula[i+1]);
            sum = operate(first,second,splitFormula[i]);
            first = sum;
        }
        return sum;
    }

    static void validateLength(int length) {
        if(length % 2 == 0) {
            throw new ArrayIndexOutOfBoundsException("계산을 할 수가 없습니다.");
        }
    }
}
