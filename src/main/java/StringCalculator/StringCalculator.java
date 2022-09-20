package StringCalculator;

import java.util.Arrays;

public class StringCalculator {
    public int stringSum(String addValues) {
        return stringSplit(addValues);
    }

    private int validateNullOrEmpty(String addValues) {
        if (addValues == null || addValues == "") {
            return 0;
        }
        return stringSplit(addValues);
    }

    private int stringSplit(String addValues) {
        return Arrays.stream(addValues.split(","))
                .mapToInt(addValue -> Integer.parseInt(addValue))
                .reduce(Integer::sum)
                .getAsInt();

    }


}
