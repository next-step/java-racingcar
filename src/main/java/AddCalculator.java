import error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AddCalculator {

    public int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        String delimiter = extractDelimiter(text);
        List<String> refinedText = removeCustomDelimiter(text);
        List<String> splitText = split(refinedText, delimiter);
        List<Integer> numbers = classifyNumbers(splitText);
        doValidation(numbers);

        return sum(numbers);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private String extractDelimiter(String target) {
        Pattern pattern = Pattern.compile("//([^\n]+)");
        Matcher matcher = pattern.matcher(target);

        if (!matcher.find()) {
            return ",|:";
        }

        StringBuffer sb = new StringBuffer();
        sb.append(matcher.group(1));
        while (matcher.find()) {
            sb.append("|");
            sb.append(matcher.group(1));
        }
        return sb.toString();
    }

    private List<String> removeCustomDelimiter(String expression) {
        Pattern pattern = Pattern.compile("//(.)\n");
        String[] splitLetters = pattern.split(expression);

        return Arrays.stream(splitLetters)
                .filter(letter -> !letter.isBlank())
                .collect(Collectors.toList());
    }

    private List<String> split(List<String> expression, String delimiter) {
        List<String> result = expression.stream()
                .flatMap(
                        e -> Arrays.stream(e.split(delimiter))
                ).collect(Collectors.toList());
        result.forEach(this::validateNumber);
        return result;
    }

    private void validateNumber(String text) {
        Matcher matcher = Pattern.compile("[^0-9-]").matcher(text);
        if (matcher.find()) {
            throw new RuntimeException(ErrorMessage.ERR_NUMBER_FORMAT_MESSAGE.print());
        }
    }

    private List<Integer> classifyNumbers(List<String> expression) {
        return expression.stream()
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    private void validateNumberRange(int number) {
        if (number < 0) {
            throw new RuntimeException(ErrorMessage.ERR_NUMBER_RANGE_MESSAGE.print());
        }
    }

    private void doValidation(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
