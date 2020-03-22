package step2;

import java.util.Scanner;

public class Main {
    private static String BLANK = " ";
    private static Validator validator = new Validator();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        validator.checkEmptyOrNullInput(input);
        String result = calculateString(input);

        System.out.println("result: " + result);
    }

    public static String calculateString(String str) {
//        validator.checkPattern(str); TODO: 정규식
        String[] splitedString = splitString(str);
        int result = Integer.parseInt(splitedString[0]);

        for(int i = 0; i < splitedString.length - 1; i += 2) {
            String operator = splitedString[i+1];
            int firstNumber = result;
            int secondNumber = Integer.parseInt(splitedString[i+2]);

            validator.checkDivideZero(operator, firstNumber);
            result = StringCalculator.calculate(operator, firstNumber, secondNumber);
        }
        return Integer.toString(result);
    }

    public static String[] splitString(String str) {
        return str.split(BLANK);
    }
}
