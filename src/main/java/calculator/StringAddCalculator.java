package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        List<String> stringValueList = SplitStringNumber.split(text);
        return sum(convert(stringValueList));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static List<PositiveNumber> convert(List<String> stringValueList) {
        List<PositiveNumber> positiveNumberList = new ArrayList<>(stringValueList.size());
        for (String value : stringValueList) {
            positiveNumberList.add(new PositiveNumber(value));
        }
        return positiveNumberList;
    }

    public static int sum(List<PositiveNumber> positiveNumberList) {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumberList) {
            sum += positiveNumber.getNumber();
        }
        return sum;
    }
}
