package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("input : ");
        String input = scanner.nextLine();

        calculator.nullCheck(input);
        calculator.operCheck(input);

        List<String> inputSplit = Arrays.asList(input.split(" "));
        int result = Integer.parseInt(inputSplit.get(0));
        for (int i = 0; i < inputSplit.size(); i++) {
            if (inputSplit.get(i).equals("+")) {
                result = calculator.add(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("-")) {
                result = calculator.subtract(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("*")) {
                result = calculator.multiply(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("/")) {
                result = calculator.divide(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
        }
        System.out.println("결과값 : " + result);
    }
}
