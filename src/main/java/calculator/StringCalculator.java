package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {

    private static Deque<Integer> operands = new ArrayDeque<>();
    private static Deque<String> operators = new ArrayDeque<>();

    static int calculate(String text) {
        String [] values = text.split(" ");

        createOperatorAndOperandStacks(values);

        return getResult();
    }

    private static int getResult() {

        Integer result = operands.getFirst();
        while( !operands.isEmpty() ) {
            Integer operand = operands.pop();

            if( operand == null ) {
                break;
            }

            String operator = operators.pop();

            if( operator.equals("+") ) {
                result += operand;
            }
            else if( operator.equals("-") ) {
                result -= operand;
            }
            else if( operator.equals("*") ) {
                result *= operand;
            }
            else if( operand.equals("/") ) {
                result /= operand;
            }

            System.out.println(operator);
            System.out.println(operand.intValue());
            System.out.println(result.intValue());
        }

        operators.clear();
        operands.clear();

        return result.intValue();
    }

    private static void createOperatorAndOperandStacks(String[] values) {
        for( String curValue : values ) {
            Integer operand = null;
            try {
                operand = Integer.parseInt(curValue);
                operands.add(operand);
            }
            catch( Exception e ) {
                if(isOperator(curValue)) {
                    operators.add(curValue);
                }
            }
        }
    }

    private static boolean isOperator(String curValue) {
        return curValue.equals("+") ||
            curValue.equals("-") ||
            curValue.equals("*") ||
            curValue.equals("/");
    }
}