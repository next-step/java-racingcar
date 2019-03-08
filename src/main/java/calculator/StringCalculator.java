package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");

        int value1 = Integer.parseInt(values[0]);
        int value2 = Integer.parseInt(values[2]);

        int result = calculate(values[1], value1, value2);

        return result;


    }

    private static int calculate(String operation, int value1, int value2) {
        int result = 0;

        switch(operation) {
            case "+" :
                result = value1 + value2;
                break;
            case "-" :
                result = value1 - value2;
                break;
            case "*" :
                result = value1 * value2;
                break;
            case "/" :
                result = value1 / value2;
        }

        return result;
    }

}
