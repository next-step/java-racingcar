import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.contains("//") && input.contains("\n")) {
            String separator = customSeparator(input);
            String custom_input = input.substring(input.indexOf("\n")+1);
            String[] inputs = custom_input.split(separator);
            return sum(inputs);
        }

        String[] inputs = input.split(",|:");
        return sum(inputs);
    }

    private static String customSeparator(String input) {
        Matcher matcher = Pattern.compile("//(?<key>;)\n.*"
        ).matcher(input);
        if (!matcher.find()) {
            throw new RuntimeException("정규식 패턴에 일치하는 구분자가 없습니다.");
        }
        return matcher.group("key");
    }

    private static int sum(String[] inputs) {
        int result = 0;
        for (String input:inputs) {
            int item = Integer.parseInt(input);
            if (item < 0) {
                throw new RuntimeException();
            }
            result+=item;
        }
        return result;
    }

}
