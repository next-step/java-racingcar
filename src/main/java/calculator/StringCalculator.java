package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");
        String exp = values[1];
        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[2]);

        int result =0;

        if(exp == "+") {
            result = num1 + num2;
        } else if (exp == "-") {
            result = num1 - num2;
        } else if (exp == "*") {
            result = num1 * num2;
        } else if (exp == "/") {
            result = num1 / num2;
        }
        return result;
    }
}
