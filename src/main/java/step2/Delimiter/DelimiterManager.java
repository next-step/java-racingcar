package step2.Delimiter;

import java.util.List;

public class DelimiterManager {
    private final List<Delimiter> delimiters = List.of(
            new CustomDelimiter(),
            new DefaultDelimiter()
    );

    public List<String> split(String input) {
        return delimiters.stream()
                .filter(delimiter -> delimiter.matches(input))
                .findFirst()
                .map(delimiter -> delimiter.split(input))
                .orElse(List.of(input));
    }
}
