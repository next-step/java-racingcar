package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculator {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) {
        String[] splitInput = input.split(" ");
        for (int i = 0; i < splitInput.length; i++) {
            if (i == splitInput.length - 1) {
                break;
            } else if (i == 0) {
                answer = Integer.parseInt(splitInput[i]);
                continue;
            }
            String element = splitInput[i];
            switch (element) {
                case "+":
                    add(splitInput[i+1]);
                    break;
                case "-":
                    subtract(splitInput[i+1]);
                    break;
                case "*":
                    multiply(splitInput[i+1]);
                    break;
                case "/":
                    divide(splitInput[i+1]);
                    break;
                default:
                    break;
            }
        }
        return answer;
    }

    public static int add(String input) {
        return answer += Integer.parseInt(input);
    }

    public static int subtract(String input) {
        return answer -= Integer.parseInt(input);
    }

    public static int multiply(String input) {
        return answer *= Integer.parseInt(input);
    }

    public static int divide(String input) {
        return answer /= Integer.parseInt(input);
    }
}
