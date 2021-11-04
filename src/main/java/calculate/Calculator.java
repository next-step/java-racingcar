package calculate;

public class Calculator {
    public int calculate(String s) {
        String[] tokens = s.split(" ");
        Integer n1 = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        Integer n2 = Integer.parseInt(tokens[2]);

        if(operator.equals("+")) {
            return n1 + n2;
        }

        if(operator.equals("-")) {
            return n1 - n2;
        }

        if(operator.equals("*")) {
            return n1 * n2;
        }

        if(operator.equals("/")) {
            if(n2 == 0) {
                throw new IllegalArgumentException("분모 0");
            }
            return n1 / n2;
        }

        throw new IllegalArgumentException("사칙연산만 가능합니다");
    }
}
