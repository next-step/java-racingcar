import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitAndSum(String input) throws Exception {
        if (isNullOrBlank(input)) {
            return 0;
        }

        String[] splitedNumbers;
        String regex = "//(.)\n(.*)";

        Matcher m = Pattern.compile(regex).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            splitedNumbers = m.group(2).split(customDelimiter);
            return sumNumbers(splitedNumbers);
        }

        splitedNumbers = input.split(",|:");
        return sumNumbers(splitedNumbers);
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if(num < 0){
                throw new RuntimeException();
            }
            sum += num;
        }
        return sum;
    }
}
