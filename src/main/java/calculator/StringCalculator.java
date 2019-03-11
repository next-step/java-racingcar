package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private int result;

    public boolean patternMatcher(String text) {
        Pattern pattern = Pattern.compile("^(([0-9]+)\\s[[+],[-],[*],[/]]\\s)+([0-9]+)$");
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }

    public int calculate(String text) {

        String[] values = splitTest(text);

        for (int i = 0; i < values.length - 1; i++) {
            result = doIntCalculate(values[i], values[i + 1]);
        }

        return result;
    }

    public String[] splitTest(String text) {

        String[] values = text.split(" ");

        result = Integer.parseInt(values[0]);

        return values;
    }

    public int doIntCalculate(String operator, String nextValue) {

        IntCalculator calc = new IntCalculator();

        switch (operator) {
            case "+":
                result = calc.add(result, Integer.parseInt(nextValue));
                break;
            case "-":
                result = calc.subtract(result, Integer.parseInt(nextValue));
                break;
            case "*":
                result = calc.multiplication(result, Integer.parseInt(nextValue));
                break;
            case "/":
                result = calc.division(result, Integer.parseInt(nextValue));
                break;
            default:
                break;
        }
        return result;
    }

    public int getResult() {
        return result;
    }

}
