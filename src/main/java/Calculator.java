import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    final static char ADD = '+';
    final static char SUBTRACT = '-';
    final static char MULTIPLY = '*';
    final static char DIVIDE = '/';

    public static void main(String[] args) {
        String expression = "2 + 3 * 4 / 2";
        double result = calculate(expression);
        System.out.println("Result: " + result);
    }

    public static double calculate(String expression) {

        ElementLists elementLists = classifyExpression(expression);

        double result = elementLists.digitList.get(0);
        for (int i = 0; i < elementLists.opList.size(); ++i) {
            result = compute(elementLists.opList.get(i), result, elementLists.digitList.get(i + 1));
        }
        return result;
    }

    // 숫자/기호 분리 함수
    public static ElementLists classifyExpression(String expression) {

        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] tokens = expression.split(" ");
        List<Double> digitList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        for (String token : tokens) {
            if (isNumeric(token)) { //숫자
                digitList.add(Double.parseDouble(token));
            } else if (isBasicOp(token)) { // 사칙연산기호
                opList.add(token.charAt(0));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return new ElementLists(digitList, opList);
    }

    public static boolean isNumeric(String token) {
        return token.chars().allMatch(Character::isDigit);
    }

    public static boolean isBasicOp(String token) {
        List<Character> basicOps = Arrays.asList(ADD, SUBTRACT, MULTIPLY, DIVIDE);
        return token.length() == 1 && basicOps.contains(token.charAt(0));
    }

    // 연산 함수
    public static double compute(char op, double a, double b) {
        switch (op) {
            case ADD:
                return add(a, b);
            case SUBTRACT:
                return subtract(a, b);
            case MULTIPLY:
                return multiply(a, b);
            case DIVIDE:
                return divide(a, b);
        }
        return -1;
    }

    // 덧셈 연산 함수
    public static double add(double a, double b) {
        return a + b;
    }

    // 뺄셈 연산 함수
    public static double subtract(double a, double b) {
        return a - b;
    }

    // 곱셈 연산 함수
    public static double multiply(double a, double b) {
        return a * b;
    }

    // 나눗셈 연산 함수
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("division by zero");
        return a / b;
    }

    private static class ElementLists {
        public List<Double> digitList;
        public List<Character> opList;

        ElementLists(List<Double> digitList, List<Character> opList) {
            this.digitList = List.copyOf(digitList);
            this.opList = List.copyOf(opList);
        }
    }
}
