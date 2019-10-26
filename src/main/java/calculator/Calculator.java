package calculator;

import java.util.List;
import java.util.Scanner;

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
        List<String> items = collection.getItem();

        long result = Long.parseLong(items.get(0));
        for (int i = 1; i < items.size() - 1; i += 2) {
            result = apply(result, items.get(i), items.get(i + 1));
        }
        return result;
    }

    private long apply(long result, String code, String number) {
        return OperatorType.findByCode(code).getExpression().apply(result, Long.parseLong(number));
    }

}
