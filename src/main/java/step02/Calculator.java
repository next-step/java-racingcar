package step02;

public class Calculator {

    public static int calculate(final String[] input) {
        int result = Integer.parseInt(input[0]);
        int max = input.length - 1;
        for (int i = 1; i < max; i += 2) {
            result = Operator.executeOf(
                    input[i],
                    result,
                    Integer.parseInt(input[i + 1])
            );
        }
        return result;
    }
}
