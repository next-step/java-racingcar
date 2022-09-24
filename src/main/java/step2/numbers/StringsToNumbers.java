package step2.numbers;

import step2.parsed.Parsed;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringsToNumbers implements Numbers {

    private final Parsed parsed;

    public StringsToNumbers(Parsed parsed) {
        this.parsed = parsed;
    }

    @Override
    public List<Integer> numbers() {
        List<String> parsedValues = parsed.parsedValue();
        return parsedValues.stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

}
