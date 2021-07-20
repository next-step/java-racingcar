package stringcalculator;

import java.util.Scanner;
import stringcalculator.util.OperationUtil;
import stringcalculator.util.UserInputValidator;

public class StringCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("처리할 연산을 공백을 포함해 입력하시오.(예: 1 + 1) :");
        String userInput = sc.nextLine();
        sc.close();

        // 1.유저 입력이 Null이나 공백문자일 경우 예외를 던짐
        UserInputValidator.validate(userInput);

        // 3. 연산
        int result = OperationUtil.calculate(userInput);

        System.out.println("결과는 : " + result);


    }

}
