package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public int stringSum(Object addValues) {
        if (validateNullOrEmpty(addValues))
            return 0;
        return stringSplit(addValues).stream().reduce(Integer::sum).get();
    }

    private boolean validateNullOrEmpty(Object addValues) {
        if (addValues == null || addValues == "") {
            return true;
        }
        return false;
    }

    private List<Integer> stringSplit(Object addValues) {
        String upcastAddValues = (String) addValues;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(upcastAddValues);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.stream(m.group(2).split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Arrays.stream(upcastAddValues.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }


}
