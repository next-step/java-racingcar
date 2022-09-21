package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int stringSum(String addValues) {
        if (validateNullOrEmpty(addValues))
            return 0;
        List<Integer> splitAddValues = stringSplitAndParseInt(addValues);
        validateNegative(splitAddValues);
        return splitAddValues.stream().reduce(Integer::sum).get();
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

    private List<Integer> stringSplitAndParseInt(String addValues) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(addValues);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.stream(m.group(2).split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Arrays.stream(addValues.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }


}
