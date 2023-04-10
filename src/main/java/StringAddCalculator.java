import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty())
            return 0;
        List<Integer> numbers = split(text);
        hasNegative(numbers);
        return sum(numbers);
    }

    private static List<Integer> split(String text) {
        List<String> targetAndSeparators = getTargetAndSeparators(text);
        String target = targetAndSeparators.get(0);
        List<String> separators = targetAndSeparators.subList(1, targetAndSeparators.size());
        return Arrays.stream(target.split(String.join("|", separators)))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> getTargetAndSeparators(String text) {
        List<String> targetAndSeparators;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return getTargetAndSeparatorsWithCustomSeparator(m);
        }
        return getTargetAndSeparatorsWithDefaultSeparator(text);
    }

    private static List<String> getTargetAndSeparatorsWithCustomSeparator(Matcher m) {
        List<String> targetAndSeparators = new ArrayList<>();
        targetAndSeparators.add(m.group(2));
        targetAndSeparators.add(m.group(1));
        targetAndSeparators.add(",");
        targetAndSeparators.add(":");
        return targetAndSeparators;
    }

    private static List<String> getTargetAndSeparatorsWithDefaultSeparator(String text) {
        List<String> targetAndSeparators = new ArrayList<>();
        targetAndSeparators.add(text);
        targetAndSeparators.add(",");
        targetAndSeparators.add(":");
        return targetAndSeparators;
    }

    private static void hasNegative(List<Integer> numbers) {
        numbers.stream()
            .filter(number -> number < 0)
            .findAny().ifPresent(number -> {
                throw new RuntimeException("Has negative number");
            });
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum)
                .get();
    }
}
