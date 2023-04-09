package calculator;

import calculator.vo.PositiveNumber;

public class Operator {
    public static int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            sum += new PositiveNumber(number).value;
        }
        return sum;
    }
}
