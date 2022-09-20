package StringCalculator;

import java.util.Arrays;
import java.util.List;
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

        return Arrays.stream(upcastAddValues.split(",|:"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }


}
