import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static int splitAndSum(String input) {
        if (input == null || input.isBlank()) return 0;

        int sum = 0;
        for (String value : StringSplitter.splitToNumber(input)) {
            sum += Integer.parseUnsignedInt(value.trim());
        }
        return sum;
    }
}
