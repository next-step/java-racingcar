import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static final int ASCII_NUMBER_ONE = 48;
    static final int ASCII_NUMBER_NINE = 57;

    static final String WHITE_SPACE = " ";
    static final char PLUS_SIGN = '+';
    static final char MINUS_SIGN = '-';
    static final char ASTERISK = '*';
    static final char SLASH = '/';

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
        parse();
    }

    private String removeWhiteSpace(String expression) {
        StringBuffer sb = new StringBuffer();
        String[] tokens = expression.split(WHITE_SPACE);

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
        return PLUS_SIGN == c || MINUS_SIGN  == c || ASTERISK == c || SLASH == c;
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
        operators.add(0, PLUS_SIGN);
        for (int i=0; i<values.size(); i++) {
            if (operators.get(i) == PLUS_SIGN) {
                result = add(result, values.get(i));
            } else if (operators.get(i) == MINUS_SIGN) {
                result = subtract(result, values.get(i));
            } else if (operators.get(i) == ASTERISK) {
                result = multiply(result, values.get(i));
            } else if (operators.get(i) == SLASH) {
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
