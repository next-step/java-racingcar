import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static final int ASCII_NUMBER_ONE = 48;
    static final int ASCII_NUMBER_NINE = 57;

    private String expression;
    private List<Integer> values;
    private List<Character> operators;
    private int result;

    public Calculator(String expression) throws IllegalArgumentException{
        if (expression == null || "".equals(expression) ) {
            throw new IllegalArgumentException("parameter is null or empty");
        }
        this.expression = removeWhiteSpace(expression);
        values = new ArrayList<>();
        operators = new ArrayList<>();
        operators.add('+');
        parse();
    }

    public String removeWhiteSpace(String expression) {
        StringBuffer sb = new StringBuffer();
        String[] tokens = expression.split(" ");
        for (String s : tokens) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void parse() {
        String str = "";
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperator(c)) {
                operators.add(c);
                values.add(Integer.parseInt(str));
                str = "";
                continue;
            }
            if (isUncheckedCharacter(c)) {
                throw new IllegalArgumentException(c + " : is unchecked character");
            }
            str += String.valueOf(c);
        }
        values.add(Integer.parseInt(str));
    }

    public boolean isOperator(char c) {
        if ('+' == c
                || '-'  == c
                || '*' == c
                || '/' == c) {
            return true;
        }
        return false;
    }

    public boolean isUncheckedCharacter(char c) {
        int ascii = (int) c;
        if (ASCII_NUMBER_ONE <= ascii
                && ascii <= ASCII_NUMBER_NINE) {
            return false;
        }
        return true;
    }

    public int calculate() {
        for (int i=0; i<values.size(); i++) {
            if (operators.get(i) == '+') {
                result = add(result, values.get(i));
            } else if (operators.get(i) == '-') {
                result = subtract(result, values.get(i));
            } else if (operators.get(i) == '*') {
                result = multiply(result, values.get(i));
            } else if (operators.get(i) == '/') {
                result = divide(result, values.get(i));
            }
         }
        return result;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

}
