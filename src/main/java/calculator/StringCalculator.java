package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String [] values = text.split(" ");
        String calc = "+";
        int result = 0;

        for (int i = 0, size = values.length; i < size; i++) {
            try {
                if (calc.equals("*")) {
                    result *= Integer.parseInt(values[i]);
                }
                if (calc.equals("/")) {
                    result /= Integer.parseInt(values[i]);
                }
                if (calc.equals("+")) {
                    result += Integer.parseInt(values[i]);
                }
                if (calc.equals("-")) {
                    result -= Integer.parseInt(values[i]);
                }
            } catch (NumberFormatException e) {
                calc = values[i];
            }
        }
        return result;
    }
}
