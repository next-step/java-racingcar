package calculator;

public class StringCalculator {

    private static String INPUT_STRING_DELIMETER = " ";

    public static Number calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 input입니다. (null or empty");
        }

        String[] chars = input.split(INPUT_STRING_DELIMETER);

        Number result = new Number(chars[0]);

        for (int i=1 ; i<chars.length ; i+=2) {
            result = Operator.of(chars[i]).operate(result, new Number(chars[i+1]));
        }

        return result;
    }

}
