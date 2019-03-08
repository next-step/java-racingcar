package calculator;

import java.util.ArrayList;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");
//
//        int first = Integer.parseInt(values[0]);
//        int second = Integer.parseInt(values[2]);
//        String expression = values[1];

        
//        ArrayList expressions = new ArrayList<String>();
//        ArrayList numbers = new ArrayList<Integer>;
//
//        for (int i = 0; i < values.length; i++) {
//            if (i % 2 == 0) {
//                expressions.add(i);
//            }
//
//            if (i % 2 == 1) {
//                numbers.add(i);
//            }
//        }

        int result = 0;



        return result;
    }

    private static int calculate(int first, int second, String expression) {

        if (expression.equals("+")) {
            return first + second;
        }

        if (expression.equals("-")) {
            return first - second;
        }

        if (expression.equals("*")) {
            return first * second;
        }

        if (expression.equals("/")) {
            return first / second;
        }
    }
}
