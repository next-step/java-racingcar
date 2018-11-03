package calculator;

public class StringCalculator {

    public static int calculator(String text) {

        String [] values = text.split(" ");

        int result = strToInt(values[0]);

        for(int i = 1; i < values.length; i+=2) {
            result = calculate(values[i], result, strToInt(values[i+1]));
        }

        return result;
    }

    private static int strToInt(String numstr) {
        return Integer.parseInt(numstr);
    }

    private static int calculate(String operation, int first, int second) {
        if(operation.equals("+")) {
            return first + second;
        }

        if(operation.equals("-")) {
            return first - second;
        }

        if(operation.equals("*")) {
            return first * second;
        }

        if(operation.equals("/")) {
            return first / second;
        }

        throw new IllegalArgumentException();
    }
}
