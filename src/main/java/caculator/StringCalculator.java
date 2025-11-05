package caculator;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String delimiterPattern = ",|:";

        if (hasCustomDelimiter(input)) {
            int newLineIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, newLineIndex);
            delimiterPattern = delimiterPattern + "|" + customDelimiter;
            input = input.substring(newLineIndex + 1);
        }

        String[] tokens = input.split(delimiterPattern);
        
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수를 입력할 수 없습니다: " + number);
            }
            sum += number;
        }

        return sum;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }
}
