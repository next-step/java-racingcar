package step2;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

public class StringAddCalculator {

    private static String createRegex(String separators) {
        return "["+separators+"]";
    }

    public int calculate(String input) {
//        if(!checkIfValidInput(input)) {
//            // "", "1", "-3", "abc" 등의 경우 처리
//            throw new IllegalArgumentException("Invalid input");
//        }
        String numbersWithSeparators = extractNumbers(input); // "\\;\n1;2;3" -> "1,2;3"
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

    public String[] checkIfOnlyNumbers(String numbersWithCustomSeparator) {
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

}
