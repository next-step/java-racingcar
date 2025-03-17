
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] divider = {",", ":"};
        String dividerRegex = String.join("|", divider);

        // Find custom divider
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            dividerRegex = m.group(1);
            text = m.group(2);
        }

        String[] stringNumbers = text.split(dividerRegex);

        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int intNumber = Integer.parseInt(stringNumber);
            if (intNumber < 0) {
                throw new RuntimeException("음수는 불가능합니다.");
            }
            sum += intNumber;
        }
        return sum;

    }
}