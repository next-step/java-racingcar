import java.util.HashSet;
import java.util.Set;

public class StringAddCalculator {
    StringNumberDelimiter delimiter;

    public StringAddCalculator(StringNumberDelimiter delimiter) {
        this.delimiter = delimiter;
    }

    public static Integer splitAndSum(String stringNumber) {
        if (stringNumber == null || stringNumber.isBlank()) {
            return 0;
        }
        String[] split = createSplitNumbersByStringNumber(stringNumber);
        if (split == null) return 0;

        Integer sum = 0;
        for (String number : split) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static String[] createSplitNumbersByStringNumber(String str) {
        String delimiter = StringNumberDelimiter.getDelimiter(str);
        if (delimiter.equals("")) {
            return null;
        }
        return str.split(delimiter);
    }
}
