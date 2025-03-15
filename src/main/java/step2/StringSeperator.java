package step2;

import step2.Delimiter.DelimiterManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSeperator {
    private static final DelimiterManager delimiterManager = new DelimiterManager();

    public List<Integer> seperate(String input) {
        if (isBlank(input)) {
            return new ArrayList<>(List.of(0));
        }
        List<String> data = delimiterManager.split(input);
        return convert(data);
    }

    private List<Integer> convert(List<String> data) {
        return data.stream()
                .map(PositiveNumber::new)
                .map(PositiveNumber::getValue)
                .collect(Collectors.toList());
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
