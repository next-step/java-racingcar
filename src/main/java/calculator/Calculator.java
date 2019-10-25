package calculator;

import java.util.Scanner;

import static calculator.NumberUtils.isNumeric;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 숫자와 연산자를 입력하세요 (ex:2 + 3 * 4 / 2)");
        String input = scanner.nextLine();

        long result = new Calculator().calculate(input);
        System.out.println("결과 : " + result);
    }

    public long calculate(String inputString) {

        CalculatorItemCollection collection = new CalculatorItemCollection(inputString);

        long result = 0;
        OperatorType operatorType = null;

        for (String s : collection.getItem()) {

            if (isNumeric(s)) {
                long number = Long.parseLong(s);
                result = operatorType == null ? number : operatorType.getExpression().apply(result, number);
                continue;
            }
            operatorType = OperatorType.findByCode(s);
        }

        return result;
    }

}
