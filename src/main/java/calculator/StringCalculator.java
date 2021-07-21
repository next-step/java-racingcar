package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculator {

    static int answer = 0;

    public enum Operator {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

        private String operator;

        private Operator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) {

        if (input == null || input.equals(""))
            throw new IllegalArgumentException();

        String[] inputArray = input.split(" ");

        for (int i = 0; i < inputArray.length; i++) {

            if (i == inputArray.length - 1)
                break;

            String inputElement = inputArray[i];
            String postElement = inputArray[i + 1];

            if (i == 0) {
                answer = toInt(inputElement);
                continue;
            }

            if (inputElement.equals(Operator.ADD.getOperator())) {
                add(postElement);
                i++;
                continue;
            }
            if (inputElement.equals(Operator.SUBTRACT.getOperator())) {
                subtract(postElement);
                i++;
                continue;
            }
            if (inputElement.equals(Operator.MULTIPLY.getOperator())) {
                multiply(postElement);
                i++;
                continue;
            }
            if (inputElement.equals(Operator.DIVIDE.getOperator())) {
                i++;
                divide(postElement);
                continue;
            }
            throw new IllegalArgumentException();
        }
        return answer;
    }

    public static int toInt(String inputElement) {
        return Integer.parseInt(inputElement);
    }

    public static int add(String postElement) {
        return answer += toInt(postElement);
    }

    public static int subtract(String postElement) {
        return answer -= toInt(postElement);
    }

    public static int multiply(String postElement) {
        return answer *= toInt(postElement);
    }

    public static int divide(String postElement) {
        return answer /= toInt(postElement);
    }
}
