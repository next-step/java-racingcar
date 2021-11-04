package stringcalculator;

public class StringCalculator {
    public int calc(String input) {
        String[] split = input.split(" ");

        Number firstNum = Number.from(split[0]);

        for (int i = 1; i < split.length - 1; i += 2) {
            Number secondNum = Number.from(split[i +1]);
            String operator = split[i];
            firstNum = Operator.calc(operator, firstNum, secondNum);
        }

        return firstNum.getNumber();
    }

}

