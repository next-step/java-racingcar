import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator3 {
    public static void main(String[] args) {
        String expression = "2 + 3 * 4 / 2";
        double result = calculate(expression);
        System.out.println("Result: " + result);
    }

    public static double calculate(String expression){
        if(expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
        //선언
        String[] tokens = expression.split(" "); // 공백을 기준으로 문자열 나누기
        List<Double> digitList = new ArrayList<>();// 2 3 4 2
        List<Character> opList = new ArrayList<>();// + * /
        List<Character> FourOpList = Arrays.asList(ADD, SUBTRACT, MULTIPLY, DIVIDE);


        for(String token : tokens) {
            //token.trim();
            boolean isNumeric = token.chars().allMatch(Character::isDigit);
            if (isNumeric){ //숫자
                digitList.add(Double.parseDouble(token));
            }else{
                if(token.length()>1 || !FourOpList.contains(token.charAt(0))){
                    throw new IllegalArgumentException();
                }
                opList.add(token.charAt(0));
            }
        }

        double result = digitList.get(0);  // 2
        for (int i = 0; i < opList.size(); ++i) {
            result = applyOp(opList.get(i), result, digitList.get(i + 1));
        }
        return result;
    }

    // 연산 함수
    public static double applyOp(char op, double a, double b) {
        switch (op) {
            case ADD :
                return add(a, b);
            case SUBTRACT :
                return subtract(a, b);
            case MULTIPLY:
                return multiply(a, b);
            case DIVIDE :
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

    final static char ADD = '+';
    final static char SUBTRACT = '-';
    final static char MULTIPLY = '*';
    final static char DIVIDE = '/';
}
