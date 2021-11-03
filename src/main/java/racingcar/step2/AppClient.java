package racingcar.step2;

import java.util.Scanner;

public class AppClient {

    public static void main(String[] args) {
        System.out.println("연산할 값을 입력해주세요");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = CalculatorUtil.blankSplit(input);
        CalculatorValidation.integratedCheck(strings);

        StringCalculator stringCalculator = new StringCalculator();
        String result = stringCalculator.calculate(strings);

        System.out.println("결과는 " + result + " 입니다");
    }

}
