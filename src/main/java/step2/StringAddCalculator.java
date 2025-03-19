package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String createRegex(String separators) {
        return "["+separators+"]";
    }

    public int calculate(String input) {
        if(checkIfEmptyInput(input)) {
            return 0;
        }
        if(!checkIfValidPattern(input)) {
            throw new IllegalArgumentException("Invalid Pattern are not allowed");
        }
        if(!checkIfOnlyPositiveNumbers(input)) {
            throw new IllegalArgumentException("Negative numbers or NaN are not allowed");
        }

        String numbersWithSeparators = extractNumbers(input); // "\\;\n1;2;3" -> "1;2;3"
        String separators = filterSeparators(input); // SEPARATORS = ",:" -> ",:;"
        int[] numbers = splitNumbers(numbersWithSeparators, separators); // e,g. "1,2;3" -> [1,2,3]
        int result = addNumbersInArray(numbers); // [1,2,3] -> 6

        return result;
    };

    public int[] splitNumbers(String numbers, String separators) {
        String regex = createRegex(separators);

        // [TODO] 강의에서 로또 미션 전까지는 stream 사용 없이 해보라는 조언
        return Arrays.stream(numbers.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int addNumbersInArray(int[] numbers) {
        int sum = 0;

        if (numbers == null) {
            return sum;
        }

        for (int num:numbers) {
            sum += num;
        }

        return sum;
    }

    private String[] checkIfOnlyNumbers(String numbersWithCustomSeparator) {
        String[] arr = numbersWithCustomSeparator.split("\n");
        return arr;
    }

    public String filterSeparators(String numbersWithCustomSeparator) {
        String separators = ",:"; // default_separators

        String[] arr = checkIfOnlyNumbers(numbersWithCustomSeparator);

        if (arr.length > 1) {
            separators += arr[0].substring(2);
        }

        return separators;
    }

    public String extractNumbers (String numbersWithCustomSeparator) {
        String[] arr = checkIfOnlyNumbers(numbersWithCustomSeparator);
        return arr[arr.length-1];
    }

    public boolean checkIfValidPattern(String input) {
        Pattern pattern = Pattern.compile("^//[^\\d]+\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkIfOnlyPositiveNumbers(String input) {
        Pattern pattern = Pattern.compile("^[\\d,:\n]*S");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkIfEmptyInput (String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }

}
