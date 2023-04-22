import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private final Pattern pattern;

    public StringCalculator() {
        this.pattern = Pattern.compile("[0-9]+");
    }


    public int sum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return add(parseStringToIntegers(split(input)));
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private int add(List<Integer> parsedNumbers) {
        int sum = 0;

        for (int parsedNumber : parsedNumbers) {
            sum += parsedNumber;
        }

        return sum;
    }

    private List<Integer> parseStringToIntegers(String[] inputComponents) {
        List<Integer> parsedNumbers = new ArrayList<>();

        for (String inputComponent : inputComponents) {
            validateNumber(inputComponent);
            parsedNumbers.add(Integer.parseInt(inputComponent));
        }

        return parsedNumbers;
    }

    private void validateNumber(String input) {
        final int number = Integer.parseInt(input);

        if (!pattern.matcher(input).find() || number < 0) {
            throw new IllegalArgumentException("입력값이 양수가 아닙니다.");
        }
    }

    public String[] split(String input) {
        if (hasCustomDelimiter(input)) {
            input = input.substring(5);
            final String delimiter = input.substring(1, 2);

            return input.split(delimiter);
        }

        return input.split(",|;");
    }

    private boolean hasCustomDelimiter(String input) {
        return input.contains("//") && input.contains("\\n");
    }
}
