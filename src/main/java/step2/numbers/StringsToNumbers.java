package step2.numbers;

import step2.parsed.Parsed;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringsToNumbers implements Numbers {

    private static final Pattern NOT_NUMBER_JUDGMENT = Pattern.compile("\\D");

    private final Parsed parsed;

    public StringsToNumbers(Parsed parsed) {
        this.parsed = parsed;
    }

    @Override
    public List<Integer> numbers() {
        verifyCanConvertNumbers();
        List<String> parsedValues = parsed.parsedValue();
        return parsedValues.stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    private void verifyCanConvertNumbers() {
        List<String> parsedValues = parsed.parsedValue();
        parsedValues.forEach(this::verifyCanConvertNumber);
    }

    private void verifyCanConvertNumber(String parsedValue) {
        if (NOT_NUMBER_JUDGMENT.matcher(parsedValue).find()) {
            throw new RuntimeException("숫자가 아니거나 음수입니다.");
        }
    }

}
