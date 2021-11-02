package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 */
public class TextCalculator {

    enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private String text;

        Operator(String text) {
            this.text = text;
        }

        public static Operator getOperator(String input) {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException();
            }

            Operator[] values = Operator.values();

            for (Operator o : values) {
                if (o.text.equals(input)) {
                    return o;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public int calculate(String input) {
        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                result += Integer.parseInt(strings[i]);
            }
        }
        return result;
    }
}
