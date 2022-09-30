package stringadder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Numbers {
    private static final Pattern CUSTOM_DELEMITER = Pattern.compile("//(.*?)\n");
    private final List<Integer> numbers;
    
    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean containsNegative() {
        return numbers.stream().anyMatch(number -> number < 0);
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static Numbers of(String numbers) {
        if (hasNoNumber(numbers)) {
            return new Numbers(Collections.emptyList());
        }
        
        if (hasCustomDelimiter(numbers)) {
            return numbers(numbers, matcher(numbers));
        }
        
        return numbers(numbers, ",:");
    }

    private static boolean hasNoNumber(String numbers) {
        return numbers == null || numbers.trim().isBlank();
    }
    
    private static boolean hasCustomDelimiter(String numbers) {
        return CUSTOM_DELEMITER.matcher(numbers).find();
    }

    private static Matcher matcher(String numbers) {
        Matcher matcher = CUSTOM_DELEMITER.matcher(numbers);
        matcher.find();
        return matcher;
    }

    private static Numbers numbers(String numbers, Matcher matcher) {
        return numbers(numbers.replaceAll(matcher.group(), ""), matcher.group(1).trim());
    }
    
    private static Numbers numbers(String numbers, String delimiter) {
        return new Numbers(Arrays.stream(numbers.split('[' + delimiter + ']'))
                                 .filter(number -> !number.isBlank())
                                 .mapToInt(Integer::parseInt)
                                 .boxed()
                                 .collect(Collectors.toList()));
    }
}
