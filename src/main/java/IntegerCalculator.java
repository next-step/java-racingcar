import java.util.Arrays;
import java.util.function.BinaryOperator;

public class IntegerCalculator implements StringCalculator<Integer> {

    private final BinaryOperator<Integer> supportedOperation;

    private final StringParser<Integer> stringParser;

    public IntegerCalculator(
        BinaryOperator<Integer> supportedOperation,
        StringParser<Integer> stringParser) {

        this.supportedOperation = supportedOperation;
        this.stringParser = stringParser;
    }

    @Override
    public Integer splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        Integer[] numbs = stringParser.parse(input);

        return calc(numbs);
    }

    private boolean isBlank(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }


    private int calc(Integer[] numbs) {
        return Arrays.stream(numbs)
            .reduce(0, supportedOperation);
    }

}
