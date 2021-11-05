package stringcalculator;

import static stringcalculator.StringUtils.split;

public class StringCalculator {
    private static final int FIRST_INDEX = 0;

    public int calc(String input) {
        String[] split = split(input);

        Number firstNum = Number.from(split[FIRST_INDEX]);

        for (int i = 1; i < split.length - 1; i += 2) {
            Number secondNum = Number.from(split[i +1]);
            String symbol = split[i];
            Operator operator = Operator.of(symbol);
            firstNum = operator.calculate(firstNum, secondNum);
        }

        return firstNum.getNumber();
    }

}

