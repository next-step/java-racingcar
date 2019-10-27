package calculator;

import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final int FIRST_INDEX = 0;
    private static final int NEXT_INDEX = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 숫자와 연산자를 입력하세요 (ex:2 + 3 * 4 / 2)");
        String input = scanner.nextLine();

        long result = calculate(input);
        System.out.println("결과 : " + result);
    }

    public static long calculate(String inputString) {

        CalculatorItemCollection collection = new CalculatorItemCollection(inputString);
        List<String> items = collection.getItem();

        int size = items.size();
        long result = Long.parseLong(items.get(FIRST_INDEX));
        for (int i = 1; i < size - 1; i += 2) {
            result = apply(result, items.get(i), items.get(i + NEXT_INDEX));
        }
        return result;
    }

    private static long apply(long number, String code, String number2) {

        long result = 0;
        try {
            result = OperatorType.findByCode(code)
                    .calculate(number, Long.parseLong(number2));

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return result;
    }

}
