import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        try {
            if (input == null || input.equals("")) {
                return 0;
            }

            if (input.length() == 1) {
                return Integer.parseInt(input);
            }

            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            String[] stringInts = {};

            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                stringInts = matcher.group(2).split(customDelimiter);
            } else {
                stringInts = input.split(",|;");
            }

            List<Integer> ints = convertStringArrayToIntArray(stringInts);
            int result = addCalculator(ints);
            return result;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private int addCalculator(List<Integer> input) {
        int sum = 0;

        for (int value : input) {
            if (value < 0) {
                throw new RuntimeException("음수는 덧셈이 불가합니다.");
            }
            sum += value;
        }

        return sum;
    }

    private List<Integer> convertStringArrayToIntArray(String[] input) {
        List<Integer> result = new ArrayList<>();

        for (String string : input) {
            result.add(Integer.parseInt(string));
        }

        return result;
    }
}
