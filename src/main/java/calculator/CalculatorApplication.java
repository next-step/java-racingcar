package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 공백으로 구분하여 입력하세요.");
        String expression = sc.nextLine();

        ElementGenerator elementGenerator = new ElementGenerator(expression);

        System.out.println(
            new Calculator(
                elementGenerator.getNumbers(), elementGenerator.getOperators()
            ).execute()
        );
    }
}
