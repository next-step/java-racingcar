package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final Pattern customDelimiter = Pattern.compile("//(.)\n(.*)");
    private static final String SEPARATOR = "[,:]";
    public int stringSum(String addValues) {
        if (validateNullOrEmpty(addValues))
            return 0;
        List<Integer> parseIntValues = stringParseInt(addValues);
        validateNegative(parseIntValues);
        return parseIntValues.stream().reduce(Integer::sum).orElse(0);
    }

    private boolean validateNullOrEmpty(String addValues) {
        return addValues == null || addValues == "";
    }

    private void validateNegative(List<Integer> splitAddValues) {
        splitAddValues.forEach(addValue -> {
            if (addValue < 0)
                throw new NegativeException("음수를 입력했습니다.");
        });
    }

    private List<Integer> stringParseInt(String addValues) {
        return Arrays.stream(stringSplit(addValues))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private String[] stringSplit(String addValues) {
        Matcher m = customDelimiter.matcher(addValues);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return addValues.split(SEPARATOR);
    }

}
