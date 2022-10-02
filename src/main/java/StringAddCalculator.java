import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final String[] defaultDelimiters = new String[]{",", ":"};
    private final Pattern customDelimiterPattern = Pattern.compile("(?://(?<delimiter>.)\\\\n)?(?<sequence>.*)");

    int sum(String input) {
        Optional<String> delimiter = Optional.empty();
        String sequence = "";

        Matcher matcher = customDelimiterPattern.matcher(input);
        if (matcher.lookingAt()) {
            delimiter = extractCustomDelimiter(matcher);
            sequence = extractSequence(matcher);
        }

        if (sequence.isEmpty()) {
            return 0;
        }
        String delimiterRegex = delimiterRegex(delimiter);

        try {
            String[] splited = sequence.split(delimiterRegex);
            List<Integer> numbers = Arrays.stream(sequence.split(delimiterRegex))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (numbers.stream().anyMatch(n -> n < 0)) {
                throw new RuntimeException();
            }

            return numbers.stream().mapToInt(Integer::intValue).sum();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    private Optional<String> extractCustomDelimiter(Matcher matcher) {
        try {
            String delimiter = matcher.group("delimiter");
            return Optional.of(delimiter);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    private String extractSequence(Matcher matcher) {
        return matcher.group("sequence");
    }

    private String delimiterRegex(Optional<String> customDelimiter) {
        String[] possibleDelimiters = customDelimiter.map(d -> new String[]{d})
                .orElse(defaultDelimiters);

        return "(" + String.join("|", possibleDelimiters) + ")";
    }
}
