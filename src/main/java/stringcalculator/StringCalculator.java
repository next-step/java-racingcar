package stringcalculator;

public class StringCalculator {
    public int calc(String input) {
        String[] split = input.split(" ");

        Number a = Number.from(split[0]);

        for (int i = 1; i < split.length - 1; i += 2) {
            Number b = Number.from(split[i +1]);
            String operator = split[i];
            a = Operator.calc(operator, a, b);
        }

        return a.getNumber();
    }

}

