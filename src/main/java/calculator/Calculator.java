package calculator;

import java.util.Scanner;

public class Calculator {
    private static final String BLANK = " ";

    public void start() {
        System.out.print("입력값 : ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        InputValidator inputValidator = new InputValidator(input);
        inputValidator.validInput();

        String[] inputArr = input.split(BLANK);

        int sum = Integer.parseInt(inputArr[0]);
        for(int i=1; i<inputArr.length; i += 2) {
            sum = Operator.calculate(inputArr[i], sum, Integer.parseInt(inputArr[i+1]));
        }

        scanner.close();
        System.out.println("결과값 : "+sum);
    }
}
