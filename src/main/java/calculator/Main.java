package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        System.out.print("input : ");
        String input = scanner.nextLine();
        calculator.nullCheck(input);
        calculator.operationCheck(input);

        String[] arithmeticOperation = input.split(" ");

        int result = Integer.parseInt(arithmeticOperation[0]);

        for (int i = 0; i < arithmeticOperation.length; i++) {
            if (arithmeticOperation[i].equals("+")) {
                result = calculator.add(result, Integer.parseInt(arithmeticOperation[i + 1]));
            } else if (arithmeticOperation[i].equals("-")) {
                result = calculator.subtract(result, Integer.parseInt(arithmeticOperation[i + 1]));
            } else if (arithmeticOperation[i].equals("*")) {
                result = calculator.multiply(result, Integer.parseInt(arithmeticOperation[i + 1]));
            } else if (arithmeticOperation[i].equals("/")) {
                result = calculator.division(result, Integer.parseInt(arithmeticOperation[i + 1]));
            }
        }

        System.out.println("결과값 : " + result);
    }
}
